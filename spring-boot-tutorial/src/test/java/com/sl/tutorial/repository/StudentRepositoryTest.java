package com.sl.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sl.tutorial.entity.Guardian;
import com.sl.tutorial.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	public void saveStudent() {
		Student student = Student.builder().emailId("shabbir@gmail.com").firstName("Shabbir").lastName("Dawoodi")
				//.guardianName("Nikhil")
				//.guardianEmail("nikhil@gmail.com")
				//.guardianMobile("9999999999")
				.build();
		studentRepository.save(student);
		
	}
	
	@Test
	public void saveStudentWithGuardian() {
		Guardian guardiam = Guardian.builder()
				.email("nikhil@gmail.com")
				.name("Nikhil")
				.mobile("9999956324")
				.build();
		Student student = Student.builder()
				.firstName("Shivam")
				.emailId("shivam@gmail.com")
				.lastName("Kumar")
				.guardian(guardiam)
				.build();
		studentRepository.save(student);
		System.out.println("student = " + student);
		
	}
	
	
	
	
	@Test
	public void printAllStudent() {
		List<Student> list = studentRepository.findAll();
		System.out.println("studentList = " + list);
	}

}
