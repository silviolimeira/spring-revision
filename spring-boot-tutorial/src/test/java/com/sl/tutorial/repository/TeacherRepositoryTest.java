package com.sl.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sl.tutorial.entity.Course;
import com.sl.tutorial.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void saveTeacher() {
		
		Course courseDBA = Course.builder().title("DBA").credit(5).build();
		Course courseJava = Course.builder().title("Java").credit(6).build();
		
		Teacher teacher =
				Teacher.builder()
				.firstName("Qutub")
				.lastName("Khan")
				.courses(List.of(courseDBA, courseJava))
				.build();
		
		
		Teacher novo = teacherRepository.save(teacher);
	}
	
	@Test
	public void listTeachers() {
		List<Teacher> teachers = teacherRepository.findAll();
		System.out.println("teachers = " + teachers);
	}

}
