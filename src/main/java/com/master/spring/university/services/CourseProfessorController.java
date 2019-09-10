package com.master.spring.university.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.spring.university.database.entities.CourseProfessor;
import com.master.spring.university.database.repositories.CourseProfessorRepository;
import com.master.spring.university.database.utils.Parameters;

@RestController
@RequestMapping("/CourseProfessor")
public class CourseProfessorController {

	@Autowired
	CourseProfessorRepository courseProfessorRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/getAllCourseProfessors")
	public List<CourseProfessor> getAllCourseProfessors() {
		logger.info("{}.getAllCourses", this.getClass().getName());
		return courseProfessorRepository.findAll();
	}

	@RequestMapping("/getCourseProfessor")
	public List<CourseProfessor> getCourseProfessor(@RequestBody CourseProfessor courseProfessor) {
		logger.info("{}.getCourseProfessor", this.getClass().getName());
		if (null == courseProfessor) {
			return null;
		}
		Parameters parameters = new Parameters();
		parameters.add("id", courseProfessor.getId());
		parameters.add("plannedCourse", courseProfessor.getPlannedCourse());
		parameters.add("professor", courseProfessor.getProfessor());

		logger.info("Parameters: {}", parameters.getAll());

		List<CourseProfessor> courseProfessors = courseProfessorRepository.findByAttributes(parameters);
		return courseProfessors;
	}
}
