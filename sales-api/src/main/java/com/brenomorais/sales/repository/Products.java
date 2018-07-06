package com.brenomorais.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brenomorais.sales.model.Product;

public interface Products extends JpaRepository<Product, Long> {
	

}
