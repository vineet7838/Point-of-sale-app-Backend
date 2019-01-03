package com.nagarro.POSApplication.dtos.mapper;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.POSApplication.dtos.ProductDTO;
import com.nagarro.POSApplication.entitys.Product;

public class ProductDTOMapper {
	public static List<ProductDTO> mapToListProductDTO(List<Product> products){
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO dto = new ProductDTO(product.getProductId(),product.getProductName(), product.getProductImage(), 
					product.getProductDescription(),product.getProductPrice(),product.getInventory1().getQuantity());
			dtos.add(dto);
					
		}
		return dtos;
	}

}
