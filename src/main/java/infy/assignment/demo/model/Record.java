package infy.assignment.demo.model;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor public class Record {
    @Autowired
    private Customer customer;
    @Autowired
    private Transaction transaction;
    private String orderStatus;
    private HashMap<String, Integer> productQuantityMap;
    private String orderId; private String orderDate; private String orderRemarks;

    public Record(Transaction transaction, Customer customer) {
    this. transaction = transaction;
    this. customer = customer;
}

}
