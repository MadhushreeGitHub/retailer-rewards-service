package infy.assignment.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.*;

/**
 * Description: This class is a model class for Customer.
 * 
 * @Param: String name : Name of the customer.
 * @Param: String email : Email of the customer.
 * @Param: Long mobileNumber : Mobile number of the customer.
 * @Param: String customerid : Unique id for the customer.
 * @Param: double customerTotalReward : Total reward points for the customer.
 * @Param: HashMap<String, Double> monthWiseReward : Reward points for each month.
 * @Param: List<TransactionDetail> transactionDetails : List of transaction details for the
 *         customer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
  private String name;
  private String email;
  private Long mobileNumber;
  private String customerid;
  private double customerTotalReward;
  private HashMap<String, Double> monthWiseReward;
  @Builder.Default
  private List<TransactionDetail> transactionDetails = new ArrayList<>();

}
