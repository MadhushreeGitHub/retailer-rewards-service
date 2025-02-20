package infy.assignment.retailer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import infy.assignment.retailer.model.Customer;
import infy.assignment.retailer.model.Record;
import infy.assignment.retailer.services.RecordService;
import infy.assignment.retailer.services.RewardService;


/**
 * Description: This class is a controller class for Reward points calculation.
 * 
 * @Param: List<Customer> customers : List of customers.
 * @Param: RewardService rewardService : Service class for reward points calculation.
 */
@RestController
@RequestMapping("/customer")
public class RewardController {
  @Autowired
  private RewardService rewardService;

  @Autowired
  private RecordService recordService;

  /**
   * Description: This method is used to get the reward points for the customer based on the
   * transaction details.
   * 
   * @Param: List<Record> recordList : List of records containing transaction details for each
   *         customer.
   * @Return: List<Customer>: List of customers with their reward points.
   */
  @PostMapping("/record")
  public List<Customer> getCustomerRewardPoints() {
    try {
      List<Record> recordList = recordService.getAllRecords();
      return rewardService.customerRewardCal(recordList);
    } catch (IllegalArgumentException e) {
      // Handle IllegalArgumentException
      System.err.println("Invalid argument: " + e.getMessage());
      // Return an empty list
      return new ArrayList<>();
    } catch (Exception e) {
      // Handle general exceptions
      System.err
          .println("An error occurred while calculating customer reward points: " + e.getMessage());
      // Return an empty list
      return new ArrayList<>();
    }
  }

}
