package Lexicon.se.henric.SchoolSystem.DAO;

import java.time.LocalDate;
import java.util.List;

import Model.Course;

public interface CourseDao {

	Course saveCourse(Course course);
	Course findByID(int id);
	List<Course> findByName(String name);
	List<Course> findByDate(LocalDate date);
	List<Course> findAll();
	boolean removeCourse(Course course);
	
}
