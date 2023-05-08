package com.sl.revision.demo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sl.revision.demo.BeanConfig;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		ShoppingCart cart = context.getBean(ShoppingCart.class);
		cart.checkout("CANCELED");
		cart.quantity();

	}

}
