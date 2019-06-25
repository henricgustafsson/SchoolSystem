package Lexicon.se.henric.SchoolSystem.DAO;

import java.time.LocalDate;
import java.util.List;

import Model.Course;
import Model.Student;

public class SchoolSystemDao implements StudentDao,CourseDao{

	private static CourseDaoList courseDaoList;
	private static StudentDaoList studentDaoList;
	
	public SchoolSystemDao() {
		courseDaoList = new CourseDaoList();
		studentDaoList = new StudentDaoList();
	}


	@Override
	public Course saveCourse(Course course) {
		
		return courseDaoList.saveCourse(course);
	}

	@Override
	public Course findCourseById(int id) {
		
		return courseDaoList.findCourseById(id);
	}

	@Override
	public List<Course> findCoursesByName(String name) {
		
		return courseDaoList.findCoursesByName(name);
	}

	@Override
	public List<Course> findCoursesByDate(LocalDate date) {
		
		return courseDaoList.findCoursesByDate(date);
	}

	@Override
	public List<Course> findAllCourses() {
		
		return courseDaoList.findAllCourses();
	}

	@Override
	public boolean removeCourse(Course course) {
		
		return removeCourse(course);
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentDaoList.saveStudent(student);
	}

	@Override
	public Student findStudentByEmail(String email) {
		
		return studentDaoList.findStudentByEmail(email);
	}

	@Override
	public List<Student> findStudentsByName(String name) {
		
		return studentDaoList.findStudentsByName(name);
	}

	@Override
	public Student findStudentById(int id) {
		
		return studentDaoList.findStudentById(id);
	}
	
	public List<Student> getAllStudents(){
		return studentDaoList.getAllStudents();
	}

	@Override
	public boolean deleteStudent(Student student) {
		
		return studentDaoList.deleteStudent(student);
	}

	
	public boolean registerStudentToCourse(Student student,Course course) {
		
		return course.registerStudentToCourse(student);
	}


	public boolean unregisterStudentFromCourse(Student student,Course course) {
		
		return course.unregisterStudentFromCourse(student);
	}

	
	
	
	

	

}
