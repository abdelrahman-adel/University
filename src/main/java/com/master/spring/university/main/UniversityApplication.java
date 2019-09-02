package com.master.spring.university.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.master.spring.university.database.entities.Student;
import com.master.spring.university.database.repositories.StudentRepository;
import com.master.spring.university.database.utils.ExtendedRepositoryImpl;
import com.master.spring.university.database.utils.Parameters;

@EntityScan(basePackages = "com.master.spring.university.database.entities")
@EnableJpaRepositories(repositoryBaseClass = ExtendedRepositoryImpl.class, basePackages = "com.master.spring.university.database.repositories")
@SpringBootApplication(scanBasePackages = "com.master.spring.university")
public class UniversityApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Student> students = studentRepository.findAll();
		for (Student student : students) {
			logger.info("StudentRepository.findAll(): {}", student);
		}

		students = studentRepository.findAll();
		for (Student student : students) {
			logger.info("StudentRepository.findAll(): {}", student);
		}

		studentRepository.findByAttributes(new Parameters());
	}

}
