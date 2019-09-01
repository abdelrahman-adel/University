package com.master.spring.university.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Semester.findByAttributes", query = "select s from Semester s where s.id=:id and s.value=:value") })
public class Semester {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "VALUE", nullable = false)
	private SemesterEnum value;

}
