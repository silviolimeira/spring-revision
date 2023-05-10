package com.sl.tutorial.service;

import java.util.List;

import com.sl.tutorial.entity.Department;
import com.sl.tutorial.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);
	public List<Department> fetchDepartmentList();
	public Department fetchDepartById(Long departmentId) throws DepartmentNotFoundException;
	public String deleteDepartmentById(Long departmentId);
	public Department updateDepartment(Long departmentId, Department department);
	public Department fetchDepartmentByName(String name);

}
