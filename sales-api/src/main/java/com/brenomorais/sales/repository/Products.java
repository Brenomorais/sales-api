package com.brenomorais.sales.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brenomorais.sales.model.Product;

public interface Products extends JpaRepository<Product, Long> {
	
	List<Product> findByName(String name); //pesquisa por nome
	
	List<Product> findByNameStartingWith(String name); //pesquisa usando o like %note% passando apenas parte do nome pesquisado
	
	Page<Product> findByNameStartingWith(String name, Pageable pegeable); //pesquisa por nome com paginação


}
