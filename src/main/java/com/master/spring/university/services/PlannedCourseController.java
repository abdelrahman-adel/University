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
		parameters.addParameter("id", plannedCourse.getId());
		parameters.addParameter("course", plannedCourse.getCourse());
		parameters.addParameter("college", plannedCourse.getCollege());
		parameters.addParameter("department", plannedCourse.getDepartment());
		parameters.addParameter("specialty", plannedCourse.getSpecialty());

		logger.info("Parameters: {}", parameters.getParametersMap());

		List<PlannedCourse> plannedCourses = plannedCourseRepository.findByAttributes(parameters);
		return plannedCourses;
	}
}
