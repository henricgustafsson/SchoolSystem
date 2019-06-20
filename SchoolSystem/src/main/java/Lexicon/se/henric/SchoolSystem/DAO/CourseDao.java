package Lexicon.se.henric.SchoolSystem.DAO;

import java.time.LocalDate;
import java.util.List;

import Model.Course;

public interface CourseDao {

	Course saveCourse(Course course);
	Course findCourseById(int id);
	List<Course> findCourseByName(String name);
	List<Course> findCourseByDate(LocalDate date);
	List<Course> findAllCourses();
	boolean removeCourse(Course course);

	
}
