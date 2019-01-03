package com.nagarro.POSApplication.entitys;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_Id", unique = true, nullable = false)
	private int productId;
	
	 @Column(name = "Product_Name", unique = true, nullable = false)
	 private String productName;
	 
	 @Column(name = "Product_Image", unique = true, nullable = false)
	 private String productImage;
	 
	 @Column(name = "Product_Description", unique = true, nullable = false)
	 private String productDescription;
	 
	 @Column(name = "Product_Price", unique = true, nullable = false)
	 private double productPrice;
	 
	 @OneToOne(fetch = FetchType.LAZY, mappedBy = "product1", cascade = CascadeType.ALL)
		private Inventory inventory1;
	
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product")
	 private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>(0);
	 
	 
	 
	 public Product() {
		 
	 }
	public Product(int productId, String productName, String productImage, String productDescription,
			float productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		
	}

	public Product(String productName, String productImage, String productDescription, float productPrice) {
		super();
		this.productName = productName;
		this.productImage = productImage;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public Inventory getInventory() {
		return inventory1;
	}

	public void setInventory(Inventory inventory1) {
		this.inventory1 = inventory1;
	}

	public Inventory getInventory1() {
		return inventory1;
	}

	public void setInventory1(Inventory inventory1) {
		this.inventory1 = inventory1;
	}

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	
	
	 
	 

}
