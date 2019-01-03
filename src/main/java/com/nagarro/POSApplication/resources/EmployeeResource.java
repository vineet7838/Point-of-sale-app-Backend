package com.nagarro.POSApplication.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.POSApplication.dtos.CashDrawerDTO;
import com.nagarro.POSApplication.dtos.CustomerDTO;
import com.nagarro.POSApplication.dtos.EmployeeDTO;
import com.nagarro.POSApplication.dtos.LoginDTO;
import com.nagarro.POSApplication.dtos.LoginResponseDTO;
import com.nagarro.POSApplication.dtos.MessageDTO;
import com.nagarro.POSApplication.dtos.OrderDTO;
import com.nagarro.POSApplication.dtos.ProductDTO;
import com.nagarro.POSApplication.services.EmployeeService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/")
public class EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value="/employee/login")
	LoginResponseDTO loginEmployee(@RequestBody LoginDTO dto) {
		return employeeService.login(dto);
		
	}
	@PostMapping(value="/employee")
	EmployeeDTO getEmployeeDetails(@RequestBody EmployeeDTO dto) {
		return employeeService.getEmployeeDetails(dto);
		
	}
	@GetMapping(value="/customer/{param}")
	List<CustomerDTO> getCustomers(@PathVariable String param) {
		return employeeService.getCustomers(param);
		
	}
	
	@GetMapping(value="/product/{param}")
	List<ProductDTO> getProducts(@PathVariable String param){
		return employeeService.getProducts(param);
	}
	
	@PostMapping(value="/employee/initial")
	LoginResponseDTO setInitialDrawerBal(@RequestBody CashDrawerDTO dto) {
		return employeeService.setInitalDrawerBal(dto);	
	}
	@PostMapping(value="/customer/order")
	MessageDTO placeOrder(@RequestBody OrderDTO dto) {
		return employeeService.placeOrder(dto);
	}
	
	

}
