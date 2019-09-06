package com.master.spring.university.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.spring.university.database.entities.AcademicYear;
import com.master.spring.university.database.repositories.AcademicYearRepository;
import com.master.spring.university.database.utils.Parameters;

@RestController
@RequestMapping("/AcademicYear")
public class AcademicYearController {

	@Autowired
	AcademicYearRepository academicYearRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/getAllAcademicYears")
	public List<AcademicYear> getAllAcademicYears() {
		logger.info("{}.getAllAcademicYears", this.getClass().getName());
		return academicYearRepository.findAll();
	}

	@RequestMapping("/getAcademicYear")
	public List<AcademicYear> getAcademicYear(@RequestBody AcademicYear academicYear) {
		logger.info("{}.getAcademicYear", this.getClass().getName());
		if (null == academicYear) {
			return null;
		}
		Parameters parameters = new Parameters();
		parameters.addParameter("id", academicYear.getId());
		parameters.addParameter("student", academicYear.getStudent());
		parameters.addParameter("plannedCourse", academicYear.getPlannedCourse());
		parameters.addParameter("academicYear", academicYear.getAcademicYear());
		parameters.addParameter("semester", academicYear.getSemester());

		logger.info("Parameters: {}", parameters.getParametersMap());

		List<AcademicYear> academicYears = academicYearRepository.findByAttributes(parameters);
		return academicYears;
	}
}
