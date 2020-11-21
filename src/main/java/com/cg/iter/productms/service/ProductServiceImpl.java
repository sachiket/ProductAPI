package com.cg.iter.productms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.productms.dto.ProductDTO;
import com.cg.iter.productms.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;


	
	@Override
	public List<ProductDTO> viewAllProducts() {
		return (List<ProductDTO>) productRepository.findAll();
	}

	@Override
	public boolean addProduct(ProductDTO product) {
		String productId = "PROD"+product.getSpecification().length()+product.getProductURL().charAt(product.getProductURL().length()-3)+productRepository.count();
		product.setProductId(productId);
		productRepository.save(product);
		return true;
	}

	@Override
	public boolean editProduct(ProductDTO product) {
		//Option is a data type 
		Optional<ProductDTO> find = productRepository.findById(product.getProductId());
		if(find.isPresent()) {
			productRepository.save(product);
			return true;
		}
		 
		return false;
	}

	@Override
	public boolean deleteProduct(String productId) {
		productRepository.deleteById(productId);
		return true;
	}

	@Override
	public ProductDTO getProductByName(String productName) {
		Optional<ProductDTO> find = productRepository.findByproductName(productName);
		if(find.isPresent()) {
			return find.get();
		}
		return null;
	}

	@Override
	public ProductDTO getProductById(String productId) {
		Optional<ProductDTO> find = productRepository.findById(productId);
		if(find.isPresent()) {
			return find.get();
		}
		return null;
	}

}
