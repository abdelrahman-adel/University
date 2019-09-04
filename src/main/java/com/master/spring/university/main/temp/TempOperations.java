package com.master.spring.university.main.temp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.master.spring.university.database.entities.Course;
import com.master.spring.university.database.entities.Student;

public class TempOperations {

	public static List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Abd-Elrahman Adel", "01147462800", "Remaya", new Date()));
		students.add(new Student("Mohamed Salah", "01026684322", "Ain Shams", new Date()));
		students.add(new Student("Mohamed Sameh", "01168923664", "Nasr City", new Date()));
		students.add(new Student("Youssef Imam", "01108312355", "Mkan", new Date()));
		students.add(new Student("Fatma Ibrahim", "01248622800", "Earth", new Date()));
		students.add(new Student("Mohamed Lotfi", "01066399922", "Mohandsen", new Date()));
		return students;
	}

	public static List<Course> getCourses() {
		List<Course> courses = new ArrayList<>();
		courses.add(new Course("Data Structures", 3));
		courses.add(new Course("OOP", 3));
		return courses;
	}
}
