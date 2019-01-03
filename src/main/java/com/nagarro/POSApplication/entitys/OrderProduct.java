package com.nagarro.POSApplication.entitys;

import java.beans.Transient;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "order_product", catalog = "posschema")
@AssociationOverrides({
		@AssociationOverride(name = "pk.order", 
			joinColumns = @JoinColumn(name = "Order_Id")),
		@AssociationOverride(name = "pk.product", 
			joinColumns = @JoinColumn(name = "Product_Id")) })
public class OrderProduct {
	@EmbeddedId
	private OrderProductId pk= new OrderProductId();
	
	@Column(name="Quantity")
	private int quantity;
	
	@Transient
	public Order getOrder() {
		return getPk().getOrder();
	}
	
	public void setOrder(Order order) {
		getPk().setOrder(order);
	}
	
	@Transient
	public Product getProduct() {
	return getPk().getProduct();	
	}
	
	public void setProduct(Product product) {
		getPk().setProduct(product);
	}
	
	public OrderProductId getPk() {
		return pk;
	}

	public void setPk(OrderProductId pk) {
		this.pk = pk;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
