package Lexicon.se.henric.SchoolSystem.DAO;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Model.Course;
import Model.Student;


public class CourseDaoList implements CourseDao{

	private static ArrayList<Course> courses;

	/**
	 * Constructor
	 */
	public CourseDaoList() {
		courses = new ArrayList<Course>();
	}
	@Override
	public Course saveCourse(Course course) {
		if(course !=null) {
			if(!courses.contains(course) && courses.add(course)) {
				return course;
			}
		}
		throw new NullPointerException();
	}

	/**
	 * Overriden method implementing interface CourseDaoList.findByID
	 * @param int id
	 * @return Course
	 *  @throws IllegalStateException
	 */
	@Override
	public Course findCourseById(int id) {
		List <Course> results =courses.stream()
				.filter(course->course.getId()==id)
				.collect(Collectors.toList());
				
				if(results.size() >1 || results.isEmpty()) {
					throw new IllegalStateException("Invalid number of results returned");
				}
				
				return results.get(0);
	}

	
	/**
	 * Overriden method implementing interface CourseDaoList.findByName
	 * @param String name
	 * @return List<Course>
	 *  @throws IllegalStateException
	 */
	@Override
	public List<Course> findCourseByName(String name) {
		if(!name.isEmpty()) {
			
			return courses.stream()
					.filter(course->course.getCourseName().equals(name))
					.collect(Collectors.toList());
		}
		
		throw new InvalidParameterException("Invalid imput, please try again");
	}

	/**
	 * Overriden method implementing interface CourseDaoList.findByDate
	 * @param LocalDate date
	 * @return List<Course>
	 *  @throws NullPointerException
	 */
	@Override
	public List<Course> findCourseByDate(LocalDate date) {
		if(date !=null) {
			
			return courses.stream()
					.filter(course->course.getCourseDate().compareTo(date)==0)
					.collect(Collectors.toList());
		}
		
		throw new NullPointerException("Invalid imput, please try again");
	}

	
	/**
	 * Overriden method implementing interface CourseDaoList.findAll
	 * @return List<Course>
	 */
	@Override
	public List<Course> findAllCourses() {
		
		return courses;
	}


	

	/**
	 * Overriden method implementing interface CourseDaoList.removeCourse
	 * @param Course course
	 * @return boolean
	 */
	@Override
	public boolean removeCourse(Course course) {
		
		return courses.remove(course);
	}

	/**
	 * Method for clearing field List<Course> courses
	 */
	public void clearCourseList() {
		courses.clear();
	}
}
