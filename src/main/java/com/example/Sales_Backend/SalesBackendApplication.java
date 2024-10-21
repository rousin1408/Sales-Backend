package com.example.Sales_Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SalesBackendApplication {
	public String PORT = System.getenv("PORT");
	public static void main(String[] args) {
		SpringApplication.run(SalesBackendApplication.class, args);
	}

}
