package com.master.spring.university.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.spring.university.database.entities.Course;
import com.master.spring.university.database.repositories.CourseRepository;
import com.master.spring.university.database.utils.Parameters;

@RestController
@RequestMapping("/Course")
public class CourseController {

	@Autowired
	CourseRepository courseRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/getAllCourses")
	public List<Course> getAllCourses() {
		logger.info("{}.getAllCourses", this.getClass().getName());
		return courseRepository.findAll();
	}

	@RequestMapping("/getCourse")
	public List<Course> getCourse(@RequestBody Course course) {
		logger.info("{}.getCourse", this.getClass().getName());
		if (null == course) {
			return null;
		}
		Parameters parameters = new Parameters();
		parameters.addParameter("id", course.getId());
		parameters.addParameter("name", course.getName());
		parameters.addParameter("creditHours", course.getCreditHours());

		logger.info("Parameters: {}", parameters.getParametersMap());

		List<Course> courses = courseRepository.findByAttributes(parameters);
		return courses;
	}
}
