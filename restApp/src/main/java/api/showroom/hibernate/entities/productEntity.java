package api.showroom.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="products")
@Table(name="products")
public class productEntity {
	
 @Id
 @Column(name="productId")
 int productId; 
 
 //@Column(name="brandId")
 //int brandId;
 @ManyToOne(targetEntity = BrandEntity.class)
 @JoinColumn(name="brandId")
 BrandEntity brandEntity; 
 
 @Column(name="productName")
 String productName;
 
 @Column(name="category")
 String category;
 
 @Column(name="cost")
 String cost;
 
 
public String getCost() {
	return cost;
}
public void setCost(String cost) {
	this.cost = cost;
}
public productEntity() {
	
}

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}

public BrandEntity getBrandEntity() {
	return brandEntity;
}
public void setBrandEntity(BrandEntity brandEntity) {
	this.brandEntity = brandEntity;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
 
 
 
}
