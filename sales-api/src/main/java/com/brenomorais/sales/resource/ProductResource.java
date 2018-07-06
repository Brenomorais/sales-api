package com.brenomorais.sales.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brenomorais.sales.model.Product;
import com.brenomorais.sales.repository.Products;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	private Products products;
	
	@GetMapping
	public List<Product> listAllProducts(){
		return products.findAll();
	}
	
	

}
