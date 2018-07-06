package com.brenomorais.sales.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brenomorais.sales.model.Sale;
import com.brenomorais.sales.repository.Products;
import com.brenomorais.sales.repository.Sales;

@RestController
@RequestMapping("/sales")
public class SaleService {
	
	@Autowired
	private Sales sales;
	
	@Autowired
	private Products products;
	
	public Sale add(Sale sale) {
		
		sale.setRegister(LocalDateTime.now());
		sale.getItens().forEach(i ->{
			i.setSale(sale);
			i.setProduct(products.findById(i.getProduct().getId()).get());
		});	
		
		BigDecimal totalItens = sale.getItens().stream()
				.map(i -> i.getProduct().getPrice().multiply(new BigDecimal(i.getAmount())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		sale.setTotal(totalItens.add(sale.getFreight()));
		
		return sales.save(sale);
	}
	
	
}
