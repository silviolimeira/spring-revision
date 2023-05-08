package com.sl.revision.demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;


//@Scope(scopeName = "singleton") // default
@Component // Nessário para usar scopeName
@Scope(scopeName = "prototype")
public class Doctor implements Staff, BeanNameAware {

	private String qualification;
	
	public void assist() {
		System.out.println("Doctor is assinting");
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Doctor [qualification=" + qualification + "]";
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Set Bean name method is called " + name);
	}
	
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("Post Construct Method is called");
	}
	
}
