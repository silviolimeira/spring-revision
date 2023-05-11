package com.sl.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sl.tutorial.entity.Guardian;
import com.sl.tutorial.entity.Student;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	// @BeforeEach
	@BeforeAll
	public void setUp() throws Exception {
		Guardian guardiam = Guardian.builder().email("nikhil@gmail.com").name("Nikhil").mobile("9999956324").build();
		Student student = Student.builder().firstName("Shivam").emailId("shivam@gmail.com").lastName("Kumar")
				.guardian(guardiam).build();
		studentRepository.save(student);
	}

	@Test
	@Disabled
	public void saveStudent() {
		Student student = Student.builder().emailId("shabbir@gmail.com").firstName("Shabbir").lastName("Dawoodi")
				// .guardianName("Nikhil")
				// .guardianEmail("nikhil@gmail.com")
				// .guardianMobile("9999999999")
				.build();
		studentRepository.save(student);

	}

	@Test
	@Disabled
	public void saveStudentWithGuardian() {
		Guardian guardiam = Guardian.builder().email("nikhil@gmail.com").name("Nikhil").mobile("9999956324").build();
		Student student = Student.builder().firstName("Shivam").emailId("shivam@gmail.com").lastName("Kumar")
				.guardian(guardiam).build();
		studentRepository.save(student);
		System.out.println("saveStudentWithGuardian = " + student);

	}

	@Test
	public void printStudentByFirstName() {
		List<Student> students = studentRepository.findByFirstName("Shivam");
		System.out.println("students = " + students);
	}

	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> students = studentRepository.findByFirstNameContaining("iv");
		System.out.println("students first name containing = " + students);
	}

	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("Nikhil");
		System.out.println("printStudentBasedOnGuardianName: " + students);
	}

	@Test
	public void printStudentBasedOnFirstNameAndLastName() {
		Student students = studentRepository.findByFirstNameAndLastName("Shivam", "Kumar");
		System.out.println("printStudentBasedOnFirstNameAndLastName: " + students);
	}

	@Test
	public void printStudenByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("shivam@gmail.com");

		System.out.println("printStudenByEmailAddress: " + student);
	}

	@Test
	public void printStudentFirstNameByEmailAddress() {
		String firstName = studentRepository.getStudentFirstNameByEmailAddress("shivam@gmail.com");
		System.out.println("printStudentFirstNameByEmailAddress: " + firstName);
	}

	@Test
	public void printGetStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("shivam@gmail.com");
		System.out.println("printGetStudentByEmailAddressNative: " + student);

	}

	@Test
	public void printAllStudent() {
		List<Student> list = studentRepository.findAll();
		System.out.println("studentList = " + list);
	}

}
