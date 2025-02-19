package infy.assignment.retailer.model;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetail {
  private LocalDate transactionDate;
  private double transactionAmount;
  private double rewardPoints;
}
