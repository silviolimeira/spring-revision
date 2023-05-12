package com.sl.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sl.tutorial.entity.Course;
import com.sl.tutorial.entity.CourseMaterial;

@SpringBootTest
class CourseRepositoryTest {

	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	
	@BeforeEach
	void setUp() throws Exception {
		Course course = Course.builder().title("DSA").credit(6).build();
		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
		CourseMaterial novo = courseMaterialRepository.save(courseMaterial);
		//courseRepository.save(course);
	}

	@Test
	void printCourses() {
		List<Course> courses =
				courseRepository.findAll();
		System.out.println("courses =  " + courses);
	}

}
