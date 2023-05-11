/**
 * 
 */
package com.sl.tutorial.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sl.tutorial.entity.Department;
import com.sl.tutorial.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentService departmentService;

	private Department department;

	@BeforeEach
	void setUp() throws Exception {

		department = Department.builder().departmentAddress("Ahmedabad").departmentCode("IT-06").departmentName("IT")
				.departmentId(1L).build();
	}

	@Test
	void testSaveDepartment() throws Exception {

		Department inputDepartment = Department.builder().departmentAddress("Ahmedabad").departmentCode("IT-06")
				.departmentName("IT").departmentId(1L).build();

		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

		mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "    \"departmentName\": \"IT\",\r\n"
						+ "    \"departmentAddress\": \"Bangalore\",\r\n" + "    \"departmentCode\": \"IT-06\"\r\n"
						+ "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testFetchDepartmentById() throws Exception {
		Mockito.when(departmentService.fetchDepartById(1L)).thenReturn(department);
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
						.value(department.getDepartmentName()));

	}

}
