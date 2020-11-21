package com.cg.iter.productms.service;

import java.util.List;

import com.cg.iter.productms.dto.ProductDTO;

public interface ProductService {

	/*
	 * name:
	 * 
	 */
	List<ProductDTO> viewAllProducts();
	/*
	 * 
	 */
	boolean addProduct(ProductDTO product);
	boolean editProduct(ProductDTO product);
	boolean deleteProduct(String productId);
	
	ProductDTO getProductByName(String productName);
	
	ProductDTO getProductById(String productId);
	
}
