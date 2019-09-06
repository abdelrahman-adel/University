package com.master.spring.university.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.master.spring.university.database.repositories.AcademicYearRepository;
import com.master.spring.university.database.repositories.CollegeRepository;
import com.master.spring.university.database.repositories.CourseProfessorRepository;
import com.master.spring.university.database.repositories.CourseRepository;
import com.master.spring.university.database.repositories.DepartmentRepository;
import com.master.spring.university.database.repositories.PlannedCourseRepository;
import com.master.spring.university.database.repositories.ProfessorRepository;
import com.master.spring.university.database.repositories.SemesterRepository;
import com.master.spring.university.database.repositories.SpecialtyRepository;
import com.master.spring.university.database.repositories.StudentRepository;
import com.master.spring.university.database.utils.ExtendedRepositoryImpl;

@EntityScan(basePackages = "com.master.spring.university.database.entities")
@EnableJpaRepositories(repositoryBaseClass = ExtendedRepositoryImpl.class, basePackages = "com.master.spring.university.database.repositories")
@SpringBootApplication(scanBasePackages = "com.master.spring.university")
public class UniversityApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	AcademicYearRepository academicYearRepository;
	@Autowired
	CollegeRepository collegeRepository;
	@Autowired
	SemesterRepository semesterRepository;
	@Autowired
	PlannedCourseRepository plannedCourseRepository;
	@Autowired
	SpecialtyRepository specialtyRepository;
	@Autowired
	CourseProfessorRepository courseProfessorRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
