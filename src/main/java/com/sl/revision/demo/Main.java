package com.sl.revision.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


	public static void main(String[] args) {
		System.out.println("Spring OK!");
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:beans.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		
		Doctor doctor = context.getBean(Doctor.class);
		doctor.assist();
		doctor.setQualification("MBBS");
//		System.out.println(doctor);
//		
//		System.out.println("Doctor 1");
//		Doctor doctor1 = context.getBean(Doctor.class);
//		System.out.println(doctor1);
		
		
		
	}

}
