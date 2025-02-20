package infy.assignment.retailer.services;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


import infy.assignment.retailer.model.Customer;
import infy.assignment.retailer.model.Record;
import infy.assignment.retailer.model.TransactionDetail;

/**
 * Description: This class is a service class for Reward points calculation for customer. All the
 * instance variables are revmoved from this class to avoid using instance variable to store the
 * request data.
 */

@Service
public class RewardService implements Reward {

  /**
   * Description: This method calculates the reward points for the customer based on the transaction
   * amount.
   * 
   * @Param: double amount : Transaction amount for which the reward points need to be calculated.
   * @Return: double : Reward points for the transaction amount.
   */
  @Override
  public double calculateRewardPoints(double amount) {
    double rewardPoints = 0;
    if (amount < 50) {
      rewardPoints = 0;
    } else if (amount >= 50 && amount <= 100) {
      rewardPoints = (amount - 50);
    } else if (amount >= 100) {
      rewardPoints = (amount - 100) * 2 + 50;
    }
    return rewardPoints;
  }


  /**
   * Description: This method iterate through the list of records and calculate the reward points
   * for each customer.
   * 
   * @Param: List<Record> transctionRecordList : List of records containing transaction details for
   *         each customer.
   * @Return: List<Customer>: List of customers with their reward points.
   */
  public List<Customer> customerRewardCal(List<Record> transctionRecordList) {
    Map<String, Customer> customerMap = new HashMap<>();
    LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);

    for (Record record : transctionRecordList) {
      processRecord(record, customerMap, threeMonthsAgo);
    }

    return new ArrayList<>(customerMap.values());
  }

  /**
   * Description: This method calculates the total reward points for the customer.
   * 
   * @param customer
   * @param recentRewardPoints
   * @return void
   */
  private void calCustomerTotalReward(Customer customer, double recentRewardPoints) {
    if (Double.compare(customer.getCustomerTotalReward(), 0.0) == 0) {
      customer.setCustomerTotalReward(recentRewardPoints);
    } else {
      customer.setCustomerTotalReward(customer.getCustomerTotalReward() + recentRewardPoints);
    }

  }

  /**
   * Description: This method updates the reward points for each customer based on the transaction
   * month.
   * 
   * @Param: Customer customer : Customer object for which the reward points need to be updated.
   * @Param: String transactionMonth : Month of the transaction.
   * @Param: double rewardPoints : Reward points for the transaction.
   * @Return: void
   */
  private void updateMontWiseReward(Customer customer, String transactionMonth,
      double rewardPoints) {

    HashMap<String, Double> monthWiseReward = customer.getMonthWiseReward();
    if (customer.getTransactionDetails() == null) {
      customer.setTransactionDetails(new ArrayList<>());
    }

    if (!transactionMonth.isEmpty() && monthWiseReward.containsKey(transactionMonth)) {
      double monthRewardValue = rewardPoints + monthWiseReward.get(transactionMonth);
      monthWiseReward.put(transactionMonth, monthRewardValue);
    } else {
      monthWiseReward.put(transactionMonth, rewardPoints);
    }
    customer.setMonthWiseReward(monthWiseReward);

  }

  /**
   * Description: This method processes the record and calculates the reward points for the
   * customer.
   * 
   * @param record : Record object containing transaction details.
   * @param customerMap : Map containing customer email as key and customer object as value.
   * @param threeMonthsAgo : Date three months ago from the current date.
   * @return void
   */
  private void processRecord(Record record, Map<String, Customer> customerMap,
      LocalDate threeMonthsAgo) {
    LocalDate transactionDate = record.getTransaction().getTransactionDate().toInstant()
        .atZone(ZoneId.systemDefault()).toLocalDate();
    if (transactionDate.isAfter(threeMonthsAgo)) {
      String transactionMonth = transactionDate.getMonth().name();
      Customer customer = record.getCustomer();
      String customerEmail = customer.getEmail();
      if (!customerMap.containsKey(customerEmail)) {
        updateCustomerMap(customerMap, customer, customerEmail);
      }
      customer = customerMap.get(customerEmail);
      double rewardPoints = calculateRewardPoints(record.getTransaction().getTransactionAmount());
      this.calCustomerTotalReward(customer, rewardPoints);
      this.updateMontWiseReward(customer, transactionMonth, rewardPoints);


      addTransactionDetail(customer, transactionDate,
          record.getTransaction().getTransactionAmount(), rewardPoints);

    }
  }

  /**
   * Description: This method adds the transaction details to the customer object.
   * 
   * @param customer : Customer object for which the transaction details need to be added.
   * @param transactionDate : Date of the transaction.
   * @param transactionAmount : Amount of the transaction.
   * @param rewardPoints: Reward points for the transaction.
   * @return void
   */
  private void addTransactionDetail(Customer customer, LocalDate transactionDate,
      double transactionAmount, double rewardPoints) {
    TransactionDetail transactionDetail = TransactionDetail.builder()
        .transactionDate(transactionDate).transactionAmount(transactionAmount)
        .rewardPoints(rewardPoints).customer(customer).build();
    List<TransactionDetail> transactionDetails = customer.getTransactionDetails();
    if (transactionDetails == null) {
      transactionDetails = new ArrayList<>();
      customer.setTransactionDetails(transactionDetails);
    }
    transactionDetails.add(transactionDetail);
  }

  /**
   * Description: This method updates the customer map with the customer object.
   * 
   * @param customerMap : Map containing customer email as key and customer object as value.
   * @param customer : Customer object to be added to the map.
   * @param customerEmail : Email of the customer.
   * @return void
   */
  private void updateCustomerMap(Map<String, Customer> customerMap, Customer customer,
      String customerEmail) {
    if (!customerMap.containsKey(customerEmail)) {
      customer.setMonthWiseReward(new HashMap<>());
      customer.setTransactionDetails(new ArrayList<>());
      customerMap.put(customerEmail, customer);
    }
  }



}
