package infy.assignment.retailer.services;

/**
 * Description: This interface is used to calculate reward points for the customer.
 * 
 * @Param: double amount : Transaction amount for which the reward points need to be calculated.
 * @Return: double : Reward points for the transaction amount.
 * 
 */

public interface Reward {
  public double calculateRewardPoints(double amount);

}
