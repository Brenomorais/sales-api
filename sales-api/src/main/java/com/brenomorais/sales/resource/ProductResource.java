package com.brenomorais.sales.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return products.findAll(Sort.by(Direction.ASC, "name"));
	}
	
	@GetMapping("/searchAll")
	public List<Product> searchAll(){
		return products.buscarTodos();
	}
	
	@GetMapping("/searchAllProduct")
	public List<Product> searchAllProduct(){
		return products.findAllProducts();
	}
	
	
	// Exemplo com os parametros URL: http://localhost:8080/products/searchByName?name=notebook
	@GetMapping("/searchByName")
	public List<Product> searchByName(@RequestParam String name){	
		return products.findByNameStartingWith(name);
	}
	
	//Exemplo pesquisa por nome e paginada: 
	@GetMapping("/searchByNamePage")
	public Page<Product> searchByNamePage(
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "ASC") Direction direction, 
			@RequestParam(defaultValue = "name") String property,
			@RequestParam String name){	
		
		return products.findByNameStartingWith(name, 
				PageRequest.of(page, size, Sort.by(direction, property)));
	}
	
	// Exemplo com os parametros URL: http://localhost:8080/products/search?size=5&page=0&direction=DESC
	@GetMapping("/searchPage") 
	public Page<Product> searchPaginated(
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "ASC") Direction direction, 
			@RequestParam(defaultValue = "name") String property){
		return products.findAll(PageRequest.of(page, size, Sort.by(direction, property)));
	}

}
