package infy.assignment.retailer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


/**
 * Description: This class is a model class for Product.
 * 
 * @Param: String productCode : Code for the product.
 * @Param: String productName : Name of the product.
 * @Param: double productPrice : Price of the product.
 * @Param: String productid : Unique id for the product.
 * @Param: Integer productAvailableQuantity : Available quantity of the product.
 * 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "product_price", nullable = false)
  private double productPrice;

  @Column(name = "product_available_quantity", nullable = false)
  private Integer productAvailableQuantity;


  @Column(name = "description")
  private String description;

}
