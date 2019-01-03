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
import javax.persistence.Table;

@Entity
@Table(name="`order`")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_Id", unique = true, nullable = false)
	private int orderId;
	 
	@Column(name = "Employee_Id", unique = false, nullable = false)
	private int employeeId;
	
	 @Column(name = "Customer_Id", unique = false, nullable = false)
	 private int customerId;
	 
	 @Column(name = "Status", unique = false, nullable = false)
	 private String status;
	 
	 @Column(name = "Payment_Mode", unique = false, nullable = true)
	 private String paymentMode;
	 
	 @Column(name = "SubTotal", unique = false, nullable = true)
	 private double subTotal;
	 
	 @Column(name = "Total", unique = false, nullable = true)
	 private double total;
	 

	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.order", cascade=CascadeType.ALL)
	 private Set<OrderProduct> orderProducts= new HashSet<OrderProduct>(0);

	 
	public Order(int employeeId, int customerId, String status, String paymentMode, double subTotal, double total) {
		super();
		this.employeeId = employeeId;
		this.customerId = customerId;
		this.status = status;
		this.paymentMode = paymentMode;
		this.subTotal = subTotal;
		this.total = total;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}


	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	
	

}
