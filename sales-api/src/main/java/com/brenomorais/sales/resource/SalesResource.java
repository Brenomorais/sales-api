package com.brenomorais.sales.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brenomorais.sales.model.Sale;
import com.brenomorais.sales.repository.Sales;
import com.brenomorais.sales.services.SaleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/sales")
public class SalesResource {
	
	@Autowired
	private Sales sales;
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public List<Sale> listALLClients(){
		return sales.findAll();
	}
	
	@PostMapping()
	public Sale addSale(@RequestBody @Valid Sale sale) {
		return saleService.add(sale);
	}
}
