package Lexicon.se.henric.SchoolSystem.DAO;

import java.time.LocalDate;
import java.util.List;

import Model.Course;

public interface CourseDao {

	Course saveCourse(Course course);
	Course findCourseById(int id);
	List<Course> findCoursesByName(String name);
	List<Course> findCoursesByDate(LocalDate date);
	List<Course> findAllCourses();
	boolean removeCourse(Course course);

	
}
