package com.sl.revision.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Doctor implements Staff {

	public void assist() {
		System.out.println("Doctor is assinting");
	}

}
