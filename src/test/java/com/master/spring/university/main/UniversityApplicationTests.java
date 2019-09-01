package com.master.spring.university.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.master.spring.university.database.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UniversityApplication.class)
public class UniversityApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository StudentRepository;

	@Test
	public void contextLoads() {

	}

}
