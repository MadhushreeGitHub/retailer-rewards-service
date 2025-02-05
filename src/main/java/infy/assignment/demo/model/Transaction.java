package infy.assignment.demo.model;

import java.util.Date;

import lombok.*;

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
