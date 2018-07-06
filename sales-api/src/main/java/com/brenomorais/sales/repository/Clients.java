package com.brenomorais.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brenomorais.sales.model.Client;

public interface Clients extends JpaRepository<Client, Long> {

}
