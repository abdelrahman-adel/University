package com.master.spring.university.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "findByAttributes", query = "select cc from CourseCollege cc where cc.id=:id") })
public class CourseCollege {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@ManyToMany(fetch = FetchType.EAGER)
	@Column(name = "COURSE_ID", nullable = false)
	private Course course;

	@ManyToMany(fetch = FetchType.EAGER)
	@Column(name = "COLLEGE_ID", nullable = false)
	private College college;

	@ManyToMany(fetch = FetchType.EAGER)
	@Column(name = "DEPARTMENT_ID", nullable = true)
	private Department department;

	@ManyToMany(fetch = FetchType.EAGER)
	@Column(name = "SPECIALTY_ID", nullable = true)
	private Specialty specialty;

}
