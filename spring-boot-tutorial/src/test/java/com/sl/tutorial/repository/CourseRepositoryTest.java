package com.sl.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sl.tutorial.entity.Course;
import com.sl.tutorial.entity.CourseMaterial;
import com.sl.tutorial.entity.Teacher;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class CourseRepositoryTest {

	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	
	@BeforeAll
	void setUp() throws Exception {
		Course course = Course.builder().title("DSA").credit(6).build();
		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
		CourseMaterial novo = courseMaterialRepository.save(courseMaterial);
		//courseRepository.save(course);
	}

	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("Priyanka").lastName("Singh").build();
		Course course = Course
				.builder()
				.title("Python")
				.credit(6)
				.teacher(teacher)
				.build();
		courseRepository.save(course);
	}
	
	@Test
	void printCourses() {
		List<Course> courses =
				courseRepository.findAll();
		System.out.println("courses =  " + courses);
	}
	

}
