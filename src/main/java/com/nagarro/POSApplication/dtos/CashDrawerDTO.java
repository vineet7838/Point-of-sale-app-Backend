package com.nagarro.POSApplication.dtos;

public class CashDrawerDTO {
	
	private int employeeId;
	private double initialBal;
	private double endingBal;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getInitialBal() {
		return initialBal;
	}
	public void setInitalBal(double initialBal) {
		this.initialBal = initialBal;
	}
	public double getEndingBal() {
		return endingBal;
	}
	public void setEndingBal(double endingBal) {
		this.endingBal = endingBal;
	}
	
	

}
