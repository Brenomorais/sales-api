package com.brenomorais.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brenomorais.sales.model.Sale;

public interface Sales extends JpaRepository<Sale, Long> {

}
