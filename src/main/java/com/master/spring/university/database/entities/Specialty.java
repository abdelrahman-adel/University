package com.master.spring.university.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "findByAttributes", query = "select s from Specialty s where s.id=:id and s.name=:name") })
public class Specialty {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.EAGER)
	@Column(name = "DEPARTMENT_ID", nullable = false)
	private Department department;

}
