package com.nagarro.POSApplication.entitys;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderProductId implements java.io.Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Order order;
	
	@ManyToOne
	private Product product;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	

}
