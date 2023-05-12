package com.sl.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sl.tutorial.entity.Course;
import com.sl.tutorial.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository repository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void saveCourseMaterialTest() {
		Course course = Course.builder().title("DSA").credit(6).build();
		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
		repository.save(courseMaterial);
		CourseMaterial novo = repository.save(courseMaterial);
		System.out.println("saveCourseMaterialTest = " + novo);
	}
	
	@Test void printAllCourseMaterials() {
		List<CourseMaterial> courseMaterials = repository.findAll();
		
		System.out.println("printAllCourseMaterials: " + courseMaterials);
	}

}
