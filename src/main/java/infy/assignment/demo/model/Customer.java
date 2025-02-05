package infy.assignment.demo.model;

import java.util.HashMap;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
private String name; private String email;
private Long mobileNumber; private String customerid;
private double customerTotalReward;
private HashMap<String, Double> monthWiseReward;

}
