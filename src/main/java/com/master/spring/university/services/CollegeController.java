package com.master.spring.university.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.spring.university.database.entities.College;
import com.master.spring.university.database.repositories.CollegeRepository;
import com.master.spring.university.database.utils.Parameters;

@RestController
@RequestMapping("/College")
public class CollegeController {

	@Autowired
	CollegeRepository collegeRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/getAllColleges")
	public List<College> getAllColleges() {
		logger.info("{}.getAllColleges", this.getClass().getName());
		return collegeRepository.findAll();
	}

	@RequestMapping("/getCollege")
	public List<College> getCollege(@RequestBody College college) {
		logger.info("{}.getCollege", this.getClass().getName());
		if (null == college) {
			return null;
		}
		Parameters parameters = new Parameters();
		parameters.add("id", college.getId());
		parameters.add("name", college.getName());
		parameters.add("deputy", college.getDeputy());

		logger.info("Parameters: {}", parameters.getAll());

		List<College> colleges = collegeRepository.findByAttributes(parameters);
		return colleges;
	}
}
