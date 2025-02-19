package infy.assignment.retailer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

public class Product {
  private String productCode;
  private String productName;
  private double productPrice;
  private String productid;
  private Integer productAvailableQuantity;

}
