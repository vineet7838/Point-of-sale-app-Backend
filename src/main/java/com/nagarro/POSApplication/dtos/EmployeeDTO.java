package com.nagarro.POSApplication.dtos;

public class EmployeeDTO {

	private int employeeId;
	private String employeeName;
	private String employeePassword;
	private double startingBal;
	private double endingBal;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
