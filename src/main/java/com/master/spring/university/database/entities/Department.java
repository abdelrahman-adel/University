package com.master.spring.university.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "findByAttributes", query = "select d from Department d where d.id=:id and d.name=:name") })
public class Department {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.EAGER)
	@Column(name = "COLLEGE_ID", nullable = false)
	private College college;

	@OneToOne(fetch = FetchType.EAGER)
	@Column(name = "PROFESSOR_ID", nullable = false)
	private Professor professor;

}
