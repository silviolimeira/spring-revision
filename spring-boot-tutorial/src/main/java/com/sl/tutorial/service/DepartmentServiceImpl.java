package com.sl.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.tutorial.entity.Department;
import com.sl.tutorial.error.DepartmentNotFoundException;
import com.sl.tutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepository.findById(departmentId);
		if (!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not Available");
		}
		return department.get();
	}

	@Override
	public String deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
		return "Department deleted Successfully!!";
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department depDB = departmentRepository.findById(departmentId).get();
		if (Objects.nonNull(department.getDepartmentName()) &&
				!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentCode()) &&
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		if (Objects.nonNull(department.getDepartmentAddress()) &&
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}		
		return departmentRepository.save(depDB);
	}

	@Override
	public Department fetchDepartmentByName(String name) {
		return departmentRepository.findByDepartmentName(name);
	}
}
