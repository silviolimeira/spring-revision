package com.sl.revision.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


	public static void main(String[] args) {
		System.out.println("Spring OK!");
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Staff nurse = (Nurse) context.getBean("nurse");
		nurse.assist();
		System.out.println(nurse);
		
		Doctor staff = context.getBean(Doctor.class);
		staff.assist();
		System.out.println(staff.getQualification());
		
		
		
	}

}
