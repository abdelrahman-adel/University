package com.master.spring.university.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.spring.university.database.entities.Professor;
import com.master.spring.university.database.repositories.ProfessorRepository;
import com.master.spring.university.database.utils.Parameters;

@RestController
@RequestMapping("/Professor")
public class ProfessorController {

	@Autowired
	ProfessorRepository professorRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/getAllProfessors")
	public List<Professor> getAllProfessors() {
		logger.info("{}.getAllProfessors", this.getClass().getName());
		return professorRepository.findAll();
	}

	@RequestMapping("/getProfessor")
	public List<Professor> getProfessor(@RequestBody Professor professor) {
		logger.info("{}.getProfessor", this.getClass().getName());
		if (null == professor) {
			return null;
		}
		Parameters parameters = new Parameters();
		parameters.add("id", professor.getId());
		parameters.add("name", professor.getName());
		parameters.add("mobile", professor.getMobile());
		parameters.add("address", professor.getAddress());

		logger.info("Parameters: {}", parameters.getAll());

		List<Professor> professors = professorRepository.findByAttributes(parameters);
		return professors;
	}
}
