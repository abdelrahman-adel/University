package com.master.spring.university.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.spring.university.database.entities.Department;
import com.master.spring.university.database.repositories.DepartmentRepository;
import com.master.spring.university.database.utils.Parameters;

@RestController
@RequestMapping("/Department")
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/getAllDepartments")
	public List<Department> getAllDepartments() {
		logger.info("{}.getAllDepartments", this.getClass().getName());
		return departmentRepository.findAll();
	}

	@RequestMapping("/getDepartment")
	public List<Department> getDepartment(@RequestBody Department department) {
		logger.info("{}.getDepartment", this.getClass().getName());
		if (null == department) {
			return null;
		}
		Parameters parameters = new Parameters();
		parameters.addParameter("id", department.getId());
		parameters.addParameter("name", department.getName());
		parameters.addParameter("college", department.getCollege());
		parameters.addParameter("head", department.getHead());

		logger.info("Parameters: {}", parameters.getParametersMap());

		List<Department> departments = departmentRepository.findByAttributes(parameters);
		return departments;
	}
}
