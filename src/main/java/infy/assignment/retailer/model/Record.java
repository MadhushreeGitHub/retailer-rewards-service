package infy.assignment.retailer.model;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Record {
  @Autowired
  private Customer customer;
  @Autowired
  private Transaction transaction;
  private String orderStatus;
  private HashMap<String, Integer> productQuantityMap;
  private String orderId;
  private String orderDate;
  private String orderRemarks;

  public Record(Transaction transaction, Customer customer) {
    this.transaction = transaction;
    this.customer = customer;
  }

}
