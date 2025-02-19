package infy.assignment.retailer.model;

import java.util.Date;

import lombok.*;

/**
 * Description: This class is a model class for Transaction.
 * 
 * @Param: Date transactionDate : Date of the transaction.
 * @Param: double transactionAmount : Amount of the transaction.
 * @Param: String transactionMode : Mode of the transaction.
 * @Param: String transactionStatus : Status of the transaction.
 * @Param: String transactionId : Unique id for the transaction.
 * @Param: String transactionRemarks : Remarks for the transaction.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
  private Date transactionDate;
  private double transactionAmount;
  private String transactionMode;
  private String transactionStatus;
  private String transactionId;
  private String transactionRemarks;

}
