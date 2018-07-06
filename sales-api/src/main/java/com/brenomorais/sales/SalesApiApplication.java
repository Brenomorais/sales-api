package com.brenomorais.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApiApplication.class, args);
		System.out.println("API Started");
	}
}
