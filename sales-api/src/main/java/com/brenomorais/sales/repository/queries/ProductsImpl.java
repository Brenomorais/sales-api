package com.brenomorais.sales.repository.queries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.brenomorais.sales.model.Product;

public class ProductsImpl  implements ProductsQueries{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Product> buscarTodos() {
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}

}
