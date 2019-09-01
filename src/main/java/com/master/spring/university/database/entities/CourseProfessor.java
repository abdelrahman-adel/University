package com.master.spring.university.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CourseProfessor {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@OneToMany(fetch = FetchType.EAGER)
	@Column(name = "COURSE_COLLEGE_ID", nullable = false)
	private CourseCollege courseCollege;

	@OneToMany(fetch = FetchType.EAGER)
	@Column(name = "PROFESSOR_ID", nullable = false)
	private Professor professor;

}
