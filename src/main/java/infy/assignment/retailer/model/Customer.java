package infy.assignment.retailer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Description: This class is a model class for Customer.
 * 
 * @Param: String name : Name of the customer.
 * @Param: String email : Email of the customer.
 * @Param: Long mobileNumber : Mobile number of the customer.
 * @Param: double customerTotalReward : Total reward points for the customer.
 * @Param: HashMap<String, Double> monthWiseReward : Reward points for each month.
 * @Param: List<TransactionDetail> transactionDetails : List of transaction details for the
 *         customer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "customer_name")
  private String name;
  @Column(name = "customer_email")
  private String email;
  @Column(name = "customer_mobile_number")
  private Long mobileNumber;

  @Column(name = "customer_total_reward")
  private double customerTotalReward;

  @ElementCollection
  @CollectionTable(name = "customer_rewards", joinColumns = @JoinColumn(name = "customer_id"))
  @MapKeyColumn(name = "month")
  @Column(name = "reward")
  private Map<String, Double> monthWiseReward;


  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  @Builder.Default
  @JsonManagedReference
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<TransactionDetail> transactionDetails = new ArrayList<>();


}
