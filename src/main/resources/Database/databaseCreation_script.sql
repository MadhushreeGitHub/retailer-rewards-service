
/**Create Database**/
CREATE DATABASE IF NOT EXISTS `retailer_db`;

/**Use Database**/
USE `retailer_db`;

/**Create Table**/
/**Table to store the customer details*
 * id - Primary Key
 * customer_name - Name of the customer
 * customer_email - Email of the customer
 * customer_mobile_number - Mobile number of the customer
 * customer_total_reward - Total reward points of the customer
*/
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) NOT NULL,
  `customer_email` varchar(255) NOT NULL,
  `customer_mobile_number` bigint DEFAULT NULL,
  `customer_total_reward` double NOT NULL,
  PRIMARY KEY (`id`)
)

/**Table to store the customer rewards details*
 * customer_id - Foreign Key
 * month - Month for which the reward points are calculated
 * reward - Reward points for the month
*/
CREATE TABLE `customer_rewards` (
  `customer_id` int NOT NULL,
  `month` varchar(255) NOT NULL,
  `reward` double DEFAULT NULL,
  PRIMARY KEY (`customer_id`,`month`),
  CONSTRAINT `customer_rewards_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE
) 

/**Table to store the product details*
 * id - Primary Key
 * product_name - Name of the product
 * description - Description of the product
 * product_price - Price of the product
 * product_available_quantity - Available quantity of the product
*/
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `product_price` double NOT NULL,
  `product_available_quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) 

/**Table to store the product Quantity details*
 * record_id - Foreign Key
 * product_id - Foreign Key
 * quantity - Quantity of the product
*/
CREATE TABLE `product_quantity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `record_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `record_id` (`record_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_quantity_ibfk_1` FOREIGN KEY (`record_id`) REFERENCES `record` (`id`),
  CONSTRAINT `product_quantity_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
)

/**Table to store the transaction information*
 * id - Primary Key
 * customer_id - Foreign Key
 * transaction_date - Date of the transaction
 * transaction_amount - Amount of the transaction
 * transaction_mode - Mode of the transaction
 * transaction_status - Status of the transaction
 * transaction_remark - Remark of the transaction
 * transaction_remarks - Remarks of the transaction
*/

CREATE TABLE `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `transaction_date` datetime(6) NOT NULL,
  `transaction_amount` double NOT NULL,
  `transaction_mode` varchar(255) NOT NULL,
  `transaction_status` varchar(255) NOT NULL,
  `transaction_remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `transaction_ibfk_001` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
)

/**Table to store the transaction detail information*
 * id - Primary Key
 * reward_points - Reward points of the transaction
 * transaction_amount - Amount of the transaction
 * transaction_date - Date of the transaction
 * customer_id - Foreign Key
*/
CREATE TABLE `transaction_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reward_points` double NOT NULL,
  `transaction_amount` double NOT NULL,
  `transaction_date` date NOT NULL,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `transaction_detail_ibfk_001` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) 



/**Table to store the Record details*
 * id - Primary Key
 * customer_id - Foreign Key
 * transaction_id - Foreign Key
 * order_status - Status of the order
 * order_date - Date of the order
 * order_remarks - Remarks of the order
*/
CREATE TABLE `record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `transaction_id` int NOT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `order_date` varchar(255) DEFAULT NULL,
  `order_remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `transaction_id` (`transaction_id`),
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `record_ibfk_2` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`)
) 

/**Table to store the record product quantity map details*
 * record_id - Foreign Key
 * product_id - Foreign Key
 * quantity - Quantity of the product
*/

CREATE TABLE `record_product_quantity_map` (
  `record_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `product_id` varchar(255) NOT NULL,
  PRIMARY KEY (`record_id`,`product_id`)
) 




