package com.nagarro.POSApplication.dtos.mapper;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.POSApplication.dtos.CustomerDTO;
import com.nagarro.POSApplication.entitys.Customer;

public class CustomerDTOMapper {

	public static List<CustomerDTO> mapToListCustomerDTO(List<Customer> customers){
		List<CustomerDTO> dtos = new ArrayList<CustomerDTO>();
		for (Customer customer : customers) {
			CustomerDTO dto = new CustomerDTO(customer.getCustomerId(), customer.getCustomerName(), 
					customer.getCustomerEmail(), customer.getCustomerPhone());
			dtos.add(dto);
					
		}
		return dtos;
	}
}
