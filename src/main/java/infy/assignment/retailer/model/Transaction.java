package infy.assignment.retailer.model;

import java.util.Date;

import jakarta.persistence.*;
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
@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "transaction_date", nullable = false)
  private Date transactionDate;

  @Column(name = "transaction_amount", nullable = false)
  private double transactionAmount;

  @Column(name = "transaction_mode", nullable = false)
  private String transactionMode;



  @Column(name = "transaction_status", nullable = false)
  private String transactionStatus;


  @Column(name = "transaction_remarks")
  private String transactionRemarks;


  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

}
