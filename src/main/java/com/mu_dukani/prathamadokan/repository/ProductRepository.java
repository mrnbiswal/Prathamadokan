package com.mu_dukani.prathamadokan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mu_dukani.prathamadokan.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
