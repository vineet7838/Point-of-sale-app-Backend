package com.nagarro.POSApplication.dtos.mapper;

import com.nagarro.POSApplication.dtos.EmployeeDTO;
import com.nagarro.POSApplication.entitys.Employee;

public class EmployeeDTOMapper {
	
	public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeId(employee.getEmployeeId());
		dto.setEmployeeName(employee.getEmployeeName());
		dto.setStartingBal(employee.getStartingBal());
		dto.setEndingBal(employee.getEndingBal());
		dto.setMessage("Success");
		return dto;
		
	}

}
