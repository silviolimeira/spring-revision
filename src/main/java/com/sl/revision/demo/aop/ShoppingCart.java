package com.sl.revision.demo.aop;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

	
	public void checkout(String status) {
		// AOP Logging
		// AOP Authentication & Authorization
		// AOP Ianitize the Data
		System.out.println("Checkout Methods ShoppingCart Called");
	}
	
	public int quantity() {
		return 2;
	}
}
