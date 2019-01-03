package com.nagarro.POSApplication.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.POSApplication.daos.EmployeeDAO;
import com.nagarro.POSApplication.dtos.CashDrawerDTO;
import com.nagarro.POSApplication.dtos.CustomerDTO;
import com.nagarro.POSApplication.dtos.EmployeeDTO;
import com.nagarro.POSApplication.dtos.LoginDTO;
import com.nagarro.POSApplication.dtos.LoginResponseDTO;
import com.nagarro.POSApplication.dtos.MessageDTO;
import com.nagarro.POSApplication.dtos.OrderDTO;
import com.nagarro.POSApplication.dtos.ProductDTO;
import com.nagarro.POSApplication.services.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public LoginResponseDTO login(LoginDTO dto) {
		return employeeDAO.loginEmployee(dto);
		
	}

	@Override
	public List<CustomerDTO> getCustomers(String param) {
		return employeeDAO.getCustomers(param);
	}

	@Override
	public List<ProductDTO> getProducts(String param) {
		
		return employeeDAO.getProducts(param);
	}

	@Override
	public LoginResponseDTO setInitalDrawerBal(CashDrawerDTO dto) {
		dto.setEndingBal(dto.getInitialBal());
		return employeeDAO.setInitialDrawerBal(dto);
	}

	@Override
	public EmployeeDTO getEmployeeDetails(EmployeeDTO dto) {
		
		return employeeDAO.getEmployeeDetails(dto);
	}

	@Override
	public MessageDTO placeOrder(OrderDTO dto) {
		if(employeeDAO.placeOrder(dto).getMessage().equalsIgnoreCase("success")) {
		
				employeeDAO.updateInventory(dto);

		}
	return null;
	}
	
	

}
