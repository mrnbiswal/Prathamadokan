package com.mu_dukani.prathamadokan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mu_dukani.prathamadokan.exception.ResourceAlreadyExitsException;
import com.mu_dukani.prathamadokan.exception.ResourceNotFoundException;
import com.mu_dukani.prathamadokan.model.Product;
import com.mu_dukani.prathamadokan.repository.ProductRepository;
import com.mu_dukani.prathamadokan.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productrepository;

	public ProductServiceImpl(ProductRepository productrepository) {
		super();
		this.productrepository = productrepository;
	}

	@Override
	public Product saveProduct(Product product) {
		if (productrepository.existsById(product.getId())) {
			throw new ResourceAlreadyExitsException();
		}
		Product saveProduct = productrepository.save(product);
		return saveProduct;
	}

	@Override
	public Product getProductById(long id) {
		return productrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public List<Product> getAllProducts() {
		return productrepository.findAll();
	}

	@Override
	public Product updateProductById(Product product, long id) {
		Product existingProduct = productrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());

		return existingProduct;
	}

	@Override
	public void deleteById(long id) {
		productrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		productrepository.deleteById(id);

	}

}
