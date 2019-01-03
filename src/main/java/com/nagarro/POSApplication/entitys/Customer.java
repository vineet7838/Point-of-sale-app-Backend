package com.nagarro.POSApplication.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_Id", unique = true, nullable = false)
	private int customerId;
	
    @Column(name = "Customer_Name", unique = true, nullable = false)
    private String customerName;
    
    @Column(name = "Customer_Email", unique = true, nullable = false)
    private String customerEmail;
    
    @Column(name = "Customer_Phone", unique = true, nullable = false)
    private int customerPhone;
    
    public Customer() {
    	
    }

	public Customer(String customerName, String customerEmail, int customerPhone) {
	
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(int customerPhone) {
		this.customerPhone = customerPhone;
	}
    
    
	
	
}
