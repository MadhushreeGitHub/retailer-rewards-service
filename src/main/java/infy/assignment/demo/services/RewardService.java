package infy.assignment.demo.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import infy.assignment.demo.model.Customer;
import infy.assignment.demo.model.Record;



@Service
public class RewardService implements Reward {

    @Override
    public double calculateRewardPoints(double amount){
        double rewardPoints = 0;
        if(amount < 50){
            rewardPoints = 0;
        }
        else if (amount >= 50 && amount <= 100) {
            rewardPoints = (amount - 50);
        }
        else if (amount >= 100) {
            rewardPoints = (amount - 100) *
            2 + 50;
        }
    return rewardPoints;
    }

    public List<Customer> customerRewardCal(List<Record> recordList) {
        Map<String, Customer> customerMap = new HashMap<> ();
        LocalDate threeMonthsAgo = LocalDate.now().minusMonths (3);

        for (Record rec : recordList) {
            LocalDate transactionDate = rec.getTransaction().getTransactionDate().toInstant().atZone(ZoneId.systemDefault()). toLocalDate();
            String transactionMonth ="";
            Customer customer = rec.getCustomer();
            String customerEmail = customer.getEmail();

            if(transactionDate. isAfter(threeMonthsAgo)) {
                double rewardPoints = calculateRewardPoints (rec.getTransaction().getTransactionAmount()); 
                transactionMonth = transactionDate.getMonth().name();

                if (!customerMap.containsKey (customerEmail)) {

                    customer.setMonthWiseReward(new HashMap<>()); 
                    customerMap.put(customerEmail, customer);
                }
                
                Customer existingCustomer = customerMap.get (customerEmail);
                HashMap<String, Double> monthWiseReward = existingCustomer.getMonthWiseReward();
                        
                if (transactionMonth != "" && monthWiseReward.containsKey (transactionMonth)) {
                        double monthRewardVal = rewardPoints + monthWiseReward.get(transactionMonth);
                        monthWiseReward. put (transactionMonth, monthRewardVal); 
                }
                else{
                    monthWiseReward. put (transactionMonth, rewardPoints);
                        
                }
                    existingCustomer.setMonthWiseReward(monthWiseReward);
                    existingCustomer.setCustomerTotalReward(existingCustomer.getCustomerTotalReward() + rewardPoints);

            }
        }

                return new ArrayList<>(customerMap.values());


    }

}
