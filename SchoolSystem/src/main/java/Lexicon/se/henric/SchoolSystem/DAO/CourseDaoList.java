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

	@Override
	public Course findByID(int id) {
		List <Course> results =courses.stream()
				.filter(course->course.getId()==id)
				.collect(Collectors.toList());
				
				if(results.size() >1 || results.isEmpty()) {
					throw new IllegalStateException("Invalid number of results returned");
				}
				
				return results.get(0);
	}

	@Override
	public List<Course> findByName(String name) {
		if(!name.isEmpty()) {
			
			return courses.stream()
					.filter(course->course.getCourseName().equals(name))
					.collect(Collectors.toList());
		}
		
		throw new InvalidParameterException("Invalid imput, please try again");
	}

	@Override
	public List<Course> findByDate(LocalDate date) {
		if(date !=null) {
			
			return courses.stream()
					.filter(course->course.getCourseDate().compareTo(date)==0)
					.collect(Collectors.toList());
		}
		
		throw new InvalidParameterException("Invalid imput, please try again");
	}

	@Override
	public List<Course> findAll() {
		
		return courses;
	}

	@Override
	public boolean removeCourse(Course course) {
		
		return courses.remove(course);
	}

}
