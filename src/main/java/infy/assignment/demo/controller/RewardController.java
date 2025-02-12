package infy.assignment.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import infy.assignment.demo.model.Customer;
import infy.assignment.demo.model.Record;
import infy.assignment.demo.services.RewardService;

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
  private List<Customer> customers = new ArrayList<Customer>();

  /**
   * Description: This method is used to get the reward points for the customer based on the
   * transaction details.
   * 
   * @Param: List<Record> recordList : List of records containing transaction details for each
   *         customer.
   * @Return: List<Customer>: List of customers with their reward points.
   */
  @PostMapping("/record")
  public List<Customer> getCustomerRewardPoints(@RequestBody List<Record> recordList) {
    this.customers = rewardService.customerRewardCal(recordList);
    return this.customers;

  }

}
