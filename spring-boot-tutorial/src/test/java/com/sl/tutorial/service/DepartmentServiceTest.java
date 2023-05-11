package com.sl.tutorial.service;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sl.tutorial.entity.Department;
import com.sl.tutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;

	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {
		Department department = Department.builder().departmentName("IT").departmentAddress("Ahmedabad")
				.departmentCode("IT-06").departmentId(1L).build();
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
		Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
	}

	@AfterEach
	@Disabled
	void setDown() {
		List<Department> list = departmentService.fetchDepartmentList();
		for (Department department : list) {
			departmentService.deleteDepartmentById(department.getDepartmentId());
		}
	}

	@Test
	@DisplayName("Get Data Based on Valid Department Name")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "IT";
		Department found = departmentService.fetchDepartmentByName(departmentName);
		Assertions.assertEquals(departmentName, found.getDepartmentName());
	}

	@Test
	@Disabled
	void whenFetchDepartmentList_thenShouldReturnADepartment() {
		List<Department> list = departmentService.fetchDepartmentList();
		int tamanho = list.size();
		Assertions.assertEquals(1, tamanho);
	}

}
