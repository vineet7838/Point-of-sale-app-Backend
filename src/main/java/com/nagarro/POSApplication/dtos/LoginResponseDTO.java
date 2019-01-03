package com.nagarro.POSApplication.dtos;

public class LoginResponseDTO {
	
	private int employeeId;
	private String message;
	
	public LoginResponseDTO() {
		
	}
	
	public LoginResponseDTO(int employeeId, String message) {
		super();
		this.employeeId = employeeId;
		this.message = message;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
