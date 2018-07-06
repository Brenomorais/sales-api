package com.brenomorais.sales.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brenomorais.sales.model.Client;
import com.brenomorais.sales.repository.Clients;

@RestController
@RequestMapping("/clients")
public class ClientResource {

	
	@Autowired
	private Clients clients;
	
	@GetMapping
	public List<Client> listALLClient(){
		return clients.findAll();
	}
}
