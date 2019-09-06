package com.master.spring.university.main.temp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.master.spring.university.database.entities.AcademicYear;
import com.master.spring.university.database.entities.College;
import com.master.spring.university.database.entities.Course;
import com.master.spring.university.database.entities.CourseProfessor;
import com.master.spring.university.database.entities.Department;
import com.master.spring.university.database.entities.PlannedCourse;
import com.master.spring.university.database.entities.Professor;
import com.master.spring.university.database.entities.Semester;
import com.master.spring.university.database.entities.SemesterEnum;
import com.master.spring.university.database.entities.Specialty;
import com.master.spring.university.database.entities.Student;
import com.master.spring.university.database.repositories.AcademicYearRepository;
import com.master.spring.university.database.repositories.CollegeRepository;
import com.master.spring.university.database.repositories.CourseProfessorRepository;
import com.master.spring.university.database.repositories.CourseRepository;
import com.master.spring.university.database.repositories.DepartmentRepository;
import com.master.spring.university.database.repositories.PlannedCourseRepository;
import com.master.spring.university.database.repositories.ProfessorRepository;
import com.master.spring.university.database.repositories.SemesterRepository;
import com.master.spring.university.database.repositories.SpecialtyRepository;
import com.master.spring.university.database.repositories.StudentRepository;

public class TempOperations {

	StudentRepository studentRepository;
	CourseRepository courseRepository;
	ProfessorRepository professorRepository;
	AcademicYearRepository academicYearRepository;
	CollegeRepository collegeRepository;
	SemesterRepository semesterRepository;
	PlannedCourseRepository plannedCourseRepository;
	SpecialtyRepository specialtyRepository;
	CourseProfessorRepository courseProfessorRepository;
	DepartmentRepository departmentRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public TempOperations(StudentRepository studentRepository, CourseRepository courseRepository,
			ProfessorRepository professorRepository, AcademicYearRepository academicYearRepository,
			SemesterRepository semesterRepository, PlannedCourseRepository plannedCourseRepository,
			CollegeRepository collegeRepository, SpecialtyRepository specialtyRepository,
			CourseProfessorRepository courseProfessorRepository, DepartmentRepository departmentRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
		this.professorRepository = professorRepository;
		this.academicYearRepository = academicYearRepository;
		this.collegeRepository = collegeRepository;
		this.semesterRepository = semesterRepository;
		this.plannedCourseRepository = plannedCourseRepository;
		this.specialtyRepository = specialtyRepository;
		this.courseProfessorRepository = courseProfessorRepository;
		this.departmentRepository = departmentRepository;
	}

	public void initializeDataBase() {
		if (checkEmptyDataBase()) {
			logger.info("Initializing Database started ..");
			List<Student> students = prepareStudents();
			List<Course> courses = prepareCourses();
			List<Professor> professors = prepareProfessors();
			List<Semester> semesters = prepareSemesters();
			List<College> colleges = prepareColleges(professors);
			List<Department> departments = prepareDepartments(colleges, professors);
			List<Specialty> specialties = prepareSpecialties(departments);
			List<PlannedCourse> plannedCourses = preparePlannedCourses(courses, colleges, departments, specialties);
			prepareCourseProfessors(plannedCourses, professors);
			prepareAcademicYears(students, plannedCourses, semesters);
		} else {
			logger.info("Database Initializing canceled ..");
		}
	}

	private boolean checkEmptyDataBase() {
		logger.info("{}.prepareStudents()", this.getClass().getSimpleName());
		List<Student> students = studentRepository.findAll();
		if (null != students && !students.isEmpty()) {
			logger.info("Database not empty ..");
			return false;
		}
		logger.info("Database empty ..");
		return true;
	}

	private List<Student> prepareStudents() {
		logger.info("{}.prepareStudents()", this.getClass().getSimpleName());
		List<Student> students = new ArrayList<>();
		students.add(new Student("Abd-Elrahman Adel", "01147462800", "Remaya", new Date()));
		students.add(new Student("Mohamed Salah", "01026684322", "Ain Shams", new Date()));
		students.add(new Student("Mohamed Sameh", "01168923664", "Nasr City", new Date()));
		students.add(new Student("Youssef Imam", "01108312355", "Mkan", new Date()));
		students.add(new Student("Fatma Ibrahim", "01248622800", "Earth", new Date()));
		students.add(new Student("Mohamed Lotfi", "01066399922", "Mohandsen", new Date()));

		studentRepository.saveAll(students);

		students = studentRepository.findAll();
		return students;
	}

	private List<Course> prepareCourses() {
		logger.info("{}.prepareCourses()", this.getClass().getSimpleName());
		List<Course> courses = new ArrayList<>();
		courses.add(new Course("Human Mind", 3));
		courses.add(new Course("Child Mind", 3));
		courses.add(new Course("Data Structures", 3));
		courses.add(new Course("OOP", 3));

		courseRepository.saveAll(courses);

		courses = courseRepository.findAll();
		return courses;
	}

	private List<Professor> prepareProfessors() {
		logger.info("{}.prepareProfessors()", this.getClass().getSimpleName());
		List<Professor> professors = new ArrayList<>();
		professors.add(new Professor("Moustafa Mahmoud", "01000002222", "Maadi"));
		professors.add(new Professor("Abeer Moustafa", "01111113632", "Maadi"));
		professors.add(new Professor("Osama Farouk", "01509922266", "Maadi"));
		professors.add(new Professor("Ibrahim Khaled", "01127363632", "Maadi"));

		professorRepository.saveAll(professors);

		professors = professorRepository.findAll();
		return professors;
	}

	private List<Semester> prepareSemesters() {
		logger.info("{}.prepareSemesters()", this.getClass().getSimpleName());
		List<Semester> semesters = new ArrayList<>();
		semesters.add(new Semester(SemesterEnum.FALL));
		semesters.add(new Semester(SemesterEnum.WINTER));
		semesters.add(new Semester(SemesterEnum.SUMMER));

		semesterRepository.saveAll(semesters);

		semesters = semesterRepository.findAll();
		return semesters;
	}

	private List<College> prepareColleges(List<Professor> professors) {
		logger.info("{}.prepareColleges()", this.getClass().getSimpleName());
		List<College> colleges = new ArrayList<>();
		colleges.add(new College("Literature", professors.get(0)));
		colleges.add(new College("Computer Science", professors.get(1)));

		collegeRepository.saveAll(colleges);

		colleges = collegeRepository.findAll();
		return colleges;
	}

	private List<Department> prepareDepartments(List<College> colleges, List<Professor> professors) {
		logger.info("{}.prepareDepartments()", this.getClass().getSimpleName());
		List<Department> departments = new ArrayList<>();
		departments.add(new Department("Phsycology", colleges.get(0), professors.get(2)));
		departments.add(new Department("Computer Science", colleges.get(1), professors.get(3)));

		departmentRepository.saveAll(departments);

		departments = departmentRepository.findAll();
		return departments;
	}

	private List<Specialty> prepareSpecialties(List<Department> departments) {
		logger.info("{}.prepareSpecialties()", this.getClass().getSimpleName());
		List<Specialty> specialties = new ArrayList<>();
		specialties.add(new Specialty("Adult Psychology", departments.get(0)));
		specialties.add(new Specialty("Child Psychology", departments.get(0)));
		specialties.add(new Specialty("Artificial Intelligence", departments.get(1)));
		specialties.add(new Specialty("Machine Learning", departments.get(1)));

		specialtyRepository.saveAll(specialties);

		specialties = specialtyRepository.findAll();
		return specialties;
	}

	private List<PlannedCourse> preparePlannedCourses(List<Course> courses, List<College> colleges,
			List<Department> departments, List<Specialty> specialties) {
		logger.info("{}.preparePlannedCourses()", this.getClass().getSimpleName());
		List<PlannedCourse> plannedCourses = new ArrayList<>();
		plannedCourses.add(new PlannedCourse(courses.get(0), colleges.get(0), departments.get(0), specialties.get(0)));// human
		plannedCourses.add(new PlannedCourse(courses.get(1), colleges.get(0), departments.get(0), specialties.get(1)));// child
		plannedCourses.add(new PlannedCourse(courses.get(2), colleges.get(1), departments.get(1), specialties.get(2)));
		plannedCourses.add(new PlannedCourse(courses.get(2), colleges.get(1), departments.get(1), specialties.get(3)));
		plannedCourses.add(new PlannedCourse(courses.get(3), colleges.get(1), departments.get(1), specialties.get(2)));
		plannedCourses.add(new PlannedCourse(courses.get(3), colleges.get(1), departments.get(1), specialties.get(3)));

		plannedCourseRepository.saveAll(plannedCourses);

		plannedCourses = plannedCourseRepository.findAll();
		return plannedCourses;

	}

	private List<CourseProfessor> prepareCourseProfessors(List<PlannedCourse> plannedCourses,
			List<Professor> professors) {
		logger.info("{}.prepareCourseProfessors()", this.getClass().getSimpleName());
		List<CourseProfessor> courseProfessors = new ArrayList<>();
		courseProfessors.add(new CourseProfessor(plannedCourses.get(0), professors.get(0)));
		courseProfessors.add(new CourseProfessor(plannedCourses.get(1), professors.get(1)));
		courseProfessors.add(new CourseProfessor(plannedCourses.get(2), professors.get(2)));
		courseProfessors.add(new CourseProfessor(plannedCourses.get(3), professors.get(3)));
		courseProfessors.add(new CourseProfessor(plannedCourses.get(4), professors.get(2)));
		courseProfessors.add(new CourseProfessor(plannedCourses.get(5), professors.get(3)));

		courseProfessorRepository.saveAll(courseProfessors);

		courseProfessors = courseProfessorRepository.findAll();
		return courseProfessors;
	}

	private List<AcademicYear> prepareAcademicYears(List<Student> students, List<PlannedCourse> plannedCourses,
			List<Semester> semesters) {
		logger.info("{}.prepareAcademicYears()", this.getClass().getSimpleName());
		List<AcademicYear> academicYears = new ArrayList<>();
		academicYears.add(new AcademicYear(students.get(0), plannedCourses.get(0), "2019/2020", semesters.get(0)));
		academicYears.add(new AcademicYear(students.get(1), plannedCourses.get(0), "2019/2020", semesters.get(0)));
		academicYears.add(new AcademicYear(students.get(2), plannedCourses.get(2), "2019/2020", semesters.get(0)));
		academicYears.add(new AcademicYear(students.get(3), plannedCourses.get(2), "2019/2020", semesters.get(0)));
		academicYears.add(new AcademicYear(students.get(4), plannedCourses.get(2), "2019/2020", semesters.get(0)));
		academicYears.add(new AcademicYear(students.get(5), plannedCourses.get(2), "2019/2020", semesters.get(0)));

		academicYears.add(new AcademicYear(students.get(0), plannedCourses.get(1), "2019/2020", semesters.get(1)));
		academicYears.add(new AcademicYear(students.get(1), plannedCourses.get(1), "2019/2020", semesters.get(1)));
		academicYears.add(new AcademicYear(students.get(2), plannedCourses.get(3), "2019/2020", semesters.get(1)));
		academicYears.add(new AcademicYear(students.get(3), plannedCourses.get(3), "2019/2020", semesters.get(1)));
		academicYears.add(new AcademicYear(students.get(4), plannedCourses.get(3), "2019/2020", semesters.get(1)));
		academicYears.add(new AcademicYear(students.get(5), plannedCourses.get(3), "2019/2020", semesters.get(1)));

		academicYears.add(new AcademicYear(students.get(0), plannedCourses.get(0), "2019/2020", semesters.get(2)));
		academicYears.add(new AcademicYear(students.get(1), plannedCourses.get(1), "2019/2020", semesters.get(2)));
		academicYears.add(new AcademicYear(students.get(2), plannedCourses.get(2), "2019/2020", semesters.get(2)));
		academicYears.add(new AcademicYear(students.get(3), plannedCourses.get(2), "2019/2020", semesters.get(2)));
		academicYears.add(new AcademicYear(students.get(4), plannedCourses.get(3), "2019/2020", semesters.get(2)));
		academicYears.add(new AcademicYear(students.get(5), plannedCourses.get(3), "2019/2020", semesters.get(2)));

		academicYearRepository.saveAll(academicYears);

		academicYears = academicYearRepository.findAll();
		return academicYears;
	}
}
