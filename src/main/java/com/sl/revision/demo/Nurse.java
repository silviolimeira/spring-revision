package com.sl.revision.demo;

public class Nurse implements Staff {

	private String name;
	
	public Nurse(String name) {
		super();
		this.name = name;
	}

	public void assist() {
		System.out.println("Nurse is assinting");
	}

	@Override
	public String toString() {
		return "Nurse [name=" + name + "]";
	}
	
}
