package com.nagarro.POSApplication.daos;

import java.util.List;

import com.nagarro.POSApplication.dtos.CashDrawerDTO;
import com.nagarro.POSApplication.dtos.CustomerDTO;
import com.nagarro.POSApplication.dtos.EmployeeDTO;
import com.nagarro.POSApplication.dtos.LoginDTO;
import com.nagarro.POSApplication.dtos.LoginResponseDTO;
import com.nagarro.POSApplication.dtos.MessageDTO;
import com.nagarro.POSApplication.dtos.OrderDTO;
import com.nagarro.POSApplication.dtos.ProductDTO;

public interface EmployeeDAO {

	LoginResponseDTO loginEmployee(LoginDTO dto);

	List<CustomerDTO> getCustomers(String param);

	List<ProductDTO> getProducts(String param);

	LoginResponseDTO setInitialDrawerBal(CashDrawerDTO dto);

	EmployeeDTO getEmployeeDetails(EmployeeDTO dto);

	MessageDTO placeOrder(OrderDTO dto);

	MessageDTO updateInventory(OrderDTO dto);

	MessageDTO updateCashDrawer(OrderDTO dto);

	List<CustomerDTO> getAllCustomers();

	List<ProductDTO> getAllProducts();

}