package com.master.spring.university.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.spring.university.database.entities.Student;
import com.master.spring.university.database.repositories.StudentRepository;
import com.master.spring.university.database.utils.Parameters;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	private static final String URL_PREFIX = "/Student";

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(URL_PREFIX + "/getAllStudents")
	public List<Student> getAllStudents() {
		logger.info("{}.getAllStudents", this.getClass().getName());
		return studentRepository.findAll();
	}

	@RequestMapping(URL_PREFIX + "/getStudent")
	public List<Student> getStudent(@RequestBody Student student) {
		if (null == student) {
			return null;
		}
		Parameters parameters = new Parameters();
		parameters.addParameter("id", student.getId());
		parameters.addParameter("name", student.getName());
		parameters.addParameter("address", student.getAddress());
		parameters.addParameter("mobile", student.getMobile());
		parameters.addParameter("joiningDate", student.getJoiningDate());
		List<Student> students = studentRepository.findByAttributes(parameters);
		return students;
	}
}
