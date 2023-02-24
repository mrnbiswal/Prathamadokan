package com.mu_dukani.prathamadokan.controller;

import java.util.List;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mu_dukani.prathamadokan.model.Product;
import com.mu_dukani.prathamadokan.service.ProductService;

@RestController
@RequestMapping("/api/product")

public class ProductController implements ErrorController {

	private ProductService productservice;

	public ProductController(ProductService productservice) {
		super();
		this.productservice = productservice;
	}

	@PostMapping()
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productservice.saveProduct(product), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		return new ResponseEntity<Product>(productservice.getProductById(id), HttpStatus.OK);
	}

	@GetMapping()
	public List<Product> getAllProducts() {
		return productservice.getAllProducts();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable long id, @RequestBody Product product) {
		return new ResponseEntity<Product>(productservice.updateProductById(product, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable long id) {
		productservice.deleteById(id);
		return new ResponseEntity<Product>(HttpStatus.OK);

	}

}
