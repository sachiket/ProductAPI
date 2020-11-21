package com.cg.iter.productms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.productms.dto.ProductDTO;
import com.cg.iter.productms.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/viewAllProducts")
	List<ProductDTO> viewAllProducts(){
		return productService.viewAllProducts();
	}
	
	@PostMapping("/addProduct")
	String addProduct(@RequestBody ProductDTO product) {
		String status = "product added";
		
		
		if(productService.addProduct(product)) {
			return status;
		}
		
		return "fail to add product!";
		
	}
	
	@PostMapping("/deleteProduct")
	String deleteProduct(@RequestParam String productId) {
		if(productService.deleteProduct(productId)) {
			return "product deleted!";
		}
		return "error";
	}
	
	@PostMapping("/editProduct")
	String editProduct(@RequestBody ProductDTO product) {
		String status = "product updated";
		
		if(productService.editProduct(product)) {
			return status;
		}
		
		return "fail to update product!";
		
	}
	
	@GetMapping("/getProductByName")
	ProductDTO getProductByName(@RequestParam String productName) {
		return productService.getProductByName(productName);
	}
	
	@GetMapping("/getProductById")
	ProductDTO getProductById(@RequestParam String productId) {
		return productService.getProductById(productId);
	}
	
	

}
