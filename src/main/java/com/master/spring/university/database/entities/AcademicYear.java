package com.master.spring.university.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AcademicYear {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@OneToMany(fetch = FetchType.LAZY)
	@Column(name = "STUDENT_ID", nullable = false)
	private Student student;

	@OneToMany(fetch = FetchType.LAZY)
	@Column(name = "COURSE_COLLEGE_ID", nullable = false)
	private CourseCollege courseCollege;

	@Column(name = "ACADEMIC_YEAR", nullable = false)
	private String academicYear;

	@OneToMany(fetch = FetchType.EAGER)
	@Column(name = "SEMESTER_ID", nullable = false)
	private Semester semester;

}
