package com.nagarro.POSApplication.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_Id", unique = true, nullable = false)
	private int employeeId;

	@Column(name = "Employee_Name", unique = false, nullable = false)
	private String employeeName;

	@Column(name = "Employee_Password", unique = false, nullable = false)
	private String employeePassword;

	@Column(name = "Starting_Bal", unique = false, nullable = false)
	private double startingBal;

	@Column(name = "Ending_Bal", unique = false, nullable = false)
	private double endingBal;
	
	public Employee() {
		
	}
	
	

	public Employee(int employeeId, String employeeName, String employeePassword, double startingBal,
			double endingBal) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		this.startingBal = startingBal;
		this.endingBal = endingBal;
	}



	public Employee(String employeeName, String employeePassword) {
		super();
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
	}

	public Employee(String employeeName, String employeePassword, float startingBal, float endingBal) {

		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		this.startingBal = startingBal;
		this.endingBal = endingBal;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public double getStartingBal() {
		return startingBal;
	}

	public void setStartingBal(double startingBal) {
		this.startingBal = startingBal;
	}

	public double getEndingBal() {
		return endingBal;
	}

	public void setEndingBal(double endingBal) {
		this.endingBal = endingBal;
	}

}
