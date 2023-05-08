package com.sl.revision.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages="com.sl.revision")
public class BeanConfig {

	@Bean
	public Doctor doctor() {
		return new Doctor();
	}
	
	@Bean
	public Nurse nourse() {
		return new Nurse();
	}
	
	
}
