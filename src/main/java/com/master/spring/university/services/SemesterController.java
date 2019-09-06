package com.master.spring.university.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.spring.university.database.entities.Semester;
import com.master.spring.university.database.repositories.SemesterRepository;
import com.master.spring.university.database.utils.Parameters;

@RestController
@RequestMapping("/Semester")
public class SemesterController {

	@Autowired
	SemesterRepository semesterRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/getAllSemesters")
	public List<Semester> getAllSemesters() {
		logger.info("{}.getAllSemesters", this.getClass().getName());
		return semesterRepository.findAll();
	}

	@RequestMapping("/getSemester")
	public List<Semester> getSemester(@RequestBody Semester semester) {
		logger.info("{}.getSemester", this.getClass().getName());
		if (null == semester) {
			return null;
		}
		Parameters parameters = new Parameters();
		parameters.addParameter("id", semester.getId());
		parameters.addParameter("value", semester.getValue());

		logger.info("Parameters: {}", parameters.getParametersMap());

		List<Semester> semesters = semesterRepository.findByAttributes(parameters);
		return semesters;
	}
}
