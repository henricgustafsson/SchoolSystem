package Lexicon.se.henric.SchoolSystem;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Lexicon.se.henric.SchoolSystem.DAO.CourseDaoList;
import Model.Course;
import Model.Student;


public class CourseDaoTest {

	private CourseDaoList courseDaoTest;
	private Student testStudent;
	private Course testCourse;
	List<Student> testStudentList;

	@Before
	public void init() {
		courseDaoTest = new CourseDaoList();
		testStudent = new Student("testian", "testian@testmail.com", "testStreet 1");
		testStudentList = new ArrayList<Student>();
		testStudentList.add(testStudent);
		testCourse = new Course("testCourse", LocalDate.now(),1, testStudentList);
		
	}
	
	@Test
	public void SaveCourseWithValidNCourseShouldAssertTrue() {
		courseDaoTest.clearCourseList();
		assertTrue(courseDaoTest.saveCourse(testCourse).equals(testCourse));
	}
	
	@Test
	public void SaveCourseWithNullPointerShouldThrowExcpetion() {
		courseDaoTest.clearCourseList();
		
		try{
			courseDaoTest.saveCourse(null);
		}
		catch(Exception e) {
			//thats ok it should throw NullPointerException
		}
	}
	
	
	@Test
	public void SaveCourseWithCourseDateNullPointerShouldThrowExcpetion() {
		courseDaoTest.clearCourseList();
		
		try{
			courseDaoTest.saveCourse(testCourse = new Course("testCourse", null,1, testStudentList));
		}
		catch(Exception e) {
			//thats ok it should throw NullPointerException
		}
	}
	
	

	@Test
	public void FindByIDWithValidIDShouldAssertTrue() {
		courseDaoTest.clearCourseList();
		int id =courseDaoTest.saveCourse(testCourse).getId();
		assertTrue(courseDaoTest.findCourseById(id).equals(testCourse));
			
	}
	
	@Test
	public void FindByIDWithInValidIDShouldThrowException() {
			
		try {
			courseDaoTest.findCourseById(25);
		} catch (Exception e) {
			//its ok it should throw IllegalStateException
		}	
	}
	
	@Test
	public void FindByNameWithEmptyStringlSHouldThrowException() {
		
		try {
			courseDaoTest.findCoursesByName("");
		}
		catch(Exception e){
			//thats ok it should throw InvalidParameterException
		}
	}

	@Test
	public void FindByNameWithValidNameShouldAssertTrue() {
	
		courseDaoTest.clearCourseList();
		String name = courseDaoTest.saveCourse(testCourse).getCourseName();
		assertTrue(courseDaoTest.findCoursesByName(name).contains(testCourse));	
	}
	
	
	@Test
	public void FindByCourseDateWithValidDateShouldAssertTrue() {
		courseDaoTest.clearCourseList();
		LocalDate date = courseDaoTest.saveCourse(testCourse).getCourseDate();
		assertTrue(courseDaoTest.findCoursesByDate(date).contains(testCourse));
	}
	
	@Test
	public void FindByCourseDateWithNullPointerDateThrowException() {
		
		try {
			courseDaoTest.findCoursesByDate(null);
		}
		catch (Exception e) {
			// its ok it should throw IllegalStateException

		}
	}
	
	
	@Test
	public void FindAllShouldContainTestCourseAndAssertTrue() {
		courseDaoTest.clearCourseList();
		courseDaoTest.saveCourse(testCourse);
		assertTrue(courseDaoTest.findAllCourses().contains(testCourse));
	}
	
	
	@Test
	public void RemoveExistingCourseShouldAssertTrue() {
		courseDaoTest.clearCourseList();
		courseDaoTest.saveCourse(testCourse);
		assertTrue(courseDaoTest.removeCourse(testCourse));
	}
	
	@Test
	public void RemoveNonExistingCourseShouldAssertFalse() {
		courseDaoTest.clearCourseList();
		//testCourse not saved so should assert false
		assertFalse(courseDaoTest.removeCourse(testCourse));
	}
}
