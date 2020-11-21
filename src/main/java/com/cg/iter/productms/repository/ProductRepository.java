package com.cg.iter.productms.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cg.iter.productms.dto.ProductDTO;

public interface ProductRepository extends CrudRepository<ProductDTO, String>{

	Optional<ProductDTO> findByproductName(String productName);

}
