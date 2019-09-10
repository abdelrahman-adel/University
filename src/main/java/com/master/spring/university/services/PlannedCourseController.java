package com.master.spring.university.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.spring.university.database.entities.PlannedCourse;
import com.master.spring.university.database.repositories.PlannedCourseRepository;
import com.master.spring.university.database.utils.Parameters;

@RestController
@RequestMapping("/PlannedCourse")
public class PlannedCourseController {

	@Autowired
	PlannedCourseRepository plannedCourseRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/getAllPlannedCourses")
	public List<PlannedCourse> getAllPlannedCourses() {
		logger.info("{}.getAllPlannedCourses", this.getClass().getName());
		return plannedCourseRepository.findAll();
	}

	@RequestMapping("/getPlannedCourse")
	public List<PlannedCourse> getPlannedCourse(@RequestBody PlannedCourse plannedCourse) {
		logger.info("{}.getCourse", this.getClass().getName());
		if (null == plannedCourse) {
			return null;
		}
		Parameters parameters = new Parameters();
		parameters.add("id", plannedCourse.getId());
		parameters.add("course", plannedCourse.getCourse());
		parameters.add("college", plannedCourse.getCollege());
		parameters.add("department", plannedCourse.getDepartment());
		parameters.add("specialty", plannedCourse.getSpecialty());

		logger.info("Parameters: {}", parameters.getAll());

		List<PlannedCourse> plannedCourses = plannedCourseRepository.findByAttributes(parameters);
		return plannedCourses;
	}
}
