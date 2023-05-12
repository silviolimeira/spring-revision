package com.sl.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
		Course course1 = Course.builder().title("SQL").credit(7).build();
		Course course2 = Course.builder().title("JPA").credit(8).build();
		Course course3 = Course.builder().title("MySQL").credit(9).build();

		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
		CourseMaterial courseMaterial1 = CourseMaterial.builder().url("www.google.com").course(course1).build();
		CourseMaterial courseMaterial2 = CourseMaterial.builder().url("www.google.com").course(course2).build();
		CourseMaterial courseMaterial3 = CourseMaterial.builder().url("www.google.com").course(course3).build();
		CourseMaterial novo = courseMaterialRepository.save(courseMaterial);
		courseMaterialRepository.saveAll(List.of(courseMaterial1, courseMaterial2, courseMaterial3));
		// courseRepository.save(course);
	}

	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder().firstName("Priyanka").lastName("Singh").build();
		Course course = Course.builder().title("Python").credit(6).teacher(teacher).build();
		courseRepository.save(course);
	}

	@Test
	void printCourses() {
		List<Course> courses = courseRepository.findAll();
		System.out.println("printCourses =  " + courses);
	}

	@Test
	public void findAllPagination() {
		PageRequest firstPageWithThreeRecords =
				PageRequest.of(0, 2);
		PageRequest secondPage = 
				PageRequest.of(1,  2);
		List<Course> courses =
				courseRepository.findAll(secondPage).getContent();
		
		Long totalElements = 
				courseRepository.findAll(secondPage)
				.getTotalElements();
		
		long totalPages =
				courseRepository.findAll(secondPage)
				.getTotalPages();
		
		System.out.println("totalPages = " + totalPages);
		
		System.out.println("totalElements = " + totalElements);
		
		System.out.println("findAllPagination = " + courses);
		
		
	}
	
	@Test
	public void findAllSorting() {
		
		Pageable sortByTitle = 
				PageRequest.of(0, 2, Sort.by("title"));
		
		Pageable sortByCreditDesc =
				PageRequest.of(0, 2, Sort.by("credit").descending());
		
		Pageable sortByTitleAndCreditDesc = 
				PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
		
		List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
		
		System.out.println("findAllSorting sortByTitle = " + courses);
		
	}

	@Test
	public void printFindByTitleContaining() {
		Pageable firstPageTenRecords =
				PageRequest.of(0, 10);
		
		List<Course> courses = 
				courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
		
		System.out.println("firstPageTenRecords findByTitleContaining = " + courses);
	}
	
}
