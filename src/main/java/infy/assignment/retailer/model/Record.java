package infy.assignment.retailer.model;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;
import lombok.*;


/**
 * Description: This class is a model class for Record.
 * 
 * @Param: Customer customer : Customer details for the record.
 * @Param: Transaction transaction : Transaction details for the record.
 * @Param: String orderStatus : Status of the order.
 * @Param: HashMap<String, Integer> productQuantityMap : Map containing product code and quantity.
 * @Param: String orderId : Unique id for the order.
 * @Param: String orderDate : Date of the order.
 * @Param: String orderRemarks : Remarks for the order.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "record")
public class Record {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id", nullable = false)
  @Autowired
  private Customer customer;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "transaction_id", nullable = false)
  @Autowired
  private Transaction transaction;

  @Column(name = "order_status")
  private String orderStatus;

  @ElementCollection
  @MapKeyColumn(name = "product_id")
  @Column(name = "quantity")
  private HashMap<String, Integer> productQuantityMap;

  @Column(name = "order_date")
  private String orderDate;

  @Column(name = "order_remarks")
  private String orderRemarks;

  public Record(Transaction transaction, Customer customer) {
    this.transaction = transaction;
    this.customer = customer;
  }

}
