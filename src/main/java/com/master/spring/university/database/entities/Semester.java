package com.master.spring.university.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Semester {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "VALUE", nullable = false)
	private SemesterEnum value;

}
