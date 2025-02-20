package infy.assignment.retailer.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "transaction_detail")
public class TransactionDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "transaction_date", nullable = false)
  private LocalDate transactionDate;

  @Column(name = "transaction_amount", nullable = false)
  private double transactionAmount;

  @Column(name = "reward_points", nullable = false)
  private double rewardPoints;

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  @JsonBackReference
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Customer customer;
}
