package com.master.spring.university.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.spring.university.database.entities.Specialty;
import com.master.spring.university.database.repositories.SpecialtyRepository;
import com.master.spring.university.database.utils.Parameters;

@RestController
@RequestMapping("/Specialty")
public class SpecialtyController {

	@Autowired
	SpecialtyRepository SpecialtyRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/getAllSpecialties")
	public List<Specialty> getAllSpecialties() {
		logger.info("{}.getAllSpecialties", this.getClass().getName());
		return SpecialtyRepository.findAll();
	}

	@RequestMapping("/getSpecialty")
	public List<Specialty> getSpecialty(@RequestBody Specialty specialty) {
		logger.info("{}.getSpecialty", this.getClass().getName());
		if (null == specialty) {
			return null;
		}
		Parameters parameters = new Parameters();
		parameters.add("id", specialty.getId());
		parameters.add("name", specialty.getName());
		parameters.add("department", specialty.getDepartment());

		logger.info("Parameters: {}", parameters.getAll());

		List<Specialty> Specialties = SpecialtyRepository.findByAttributes(parameters);
		return Specialties;
	}
}
