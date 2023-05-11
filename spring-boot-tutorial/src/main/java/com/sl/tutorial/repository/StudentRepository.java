package com.sl.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sl.tutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstName(String firstName);

	List<Student> findByFirstNameContaining(String name);

	List<Student> findByLastNameNotNull();

	List<Student> findByGuardianName(String guardianName);

	Student findByFirstNameAndLastName(String firstName, String lastName);

	// JPQL
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);

	// JPQL
	@Query("select s.firstName from Student s where s.emailId = ?1")
	String getStudentFirstNameByEmailAddress(String firstName);

	@Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1", nativeQuery = true)
	Student getStudentByEmailAddressNative(String emailId);
}
