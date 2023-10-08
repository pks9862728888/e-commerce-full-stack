package com.demo.ecommerce;

import com.demo.ecommerce.initializer.DataInitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	private DataInitializerService dataInitializerService;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataInitializerService.initProducts();
	}
}
