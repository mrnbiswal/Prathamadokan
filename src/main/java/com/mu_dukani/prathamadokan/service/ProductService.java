package com.mu_dukani.prathamadokan.service;

import java.util.List;

import com.mu_dukani.prathamadokan.exception.ResourceAlreadyExitsException;
import com.mu_dukani.prathamadokan.exception.ResourceNotFoundException;
import com.mu_dukani.prathamadokan.model.Product;

public interface ProductService {
	Product saveProduct(Product product) throws ResourceAlreadyExitsException ;

	Product getProductById(long id) throws ResourceNotFoundException;

	List<Product> getAllProducts() throws ResourceNotFoundException;

	Product updateProductById(Product product, long id);

	void deleteById(long id);
}
