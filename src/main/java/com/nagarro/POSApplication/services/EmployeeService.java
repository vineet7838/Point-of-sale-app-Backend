package com.nagarro.POSApplication.services;

import java.util.List;

import com.nagarro.POSApplication.dtos.CashDrawerDTO;
import com.nagarro.POSApplication.dtos.CustomerDTO;
import com.nagarro.POSApplication.dtos.EmployeeDTO;
import com.nagarro.POSApplication.dtos.LoginDTO;
import com.nagarro.POSApplication.dtos.LoginResponseDTO;
import com.nagarro.POSApplication.dtos.MessageDTO;
import com.nagarro.POSApplication.dtos.OrderDTO;
import com.nagarro.POSApplication.dtos.ProductDTO;

public interface EmployeeService {

	LoginResponseDTO login(LoginDTO dto);

	List<CustomerDTO> getCustomers(String param);

	List<ProductDTO> getProducts(String param);

	LoginResponseDTO setInitalDrawerBal(CashDrawerDTO dto);

	EmployeeDTO getEmployeeDetails(EmployeeDTO dto);

	MessageDTO placeOrder(OrderDTO dto);

}