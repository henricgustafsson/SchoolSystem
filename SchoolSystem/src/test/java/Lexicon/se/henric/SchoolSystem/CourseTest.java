package Lexicon.se.henric.SchoolSystem;

import static org.junit.Assert.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Model.Course;
import Model.Student;

/**
 * @author deltagare
 *
 */
public class CourseTest {
	

	
	private Course testCourse;
	private List<Student> testStudentList;
	Student testStudent;
	Course anotherTestCourse;
	
	@Before
	public void init() {
		testStudentList = new ArrayList<Student>();
		testStudentList.add(new Student("Testor Testerson", "testerson@testmail.com", "TestStreet 1312"));
		testStudentList.add(new Student("Testiana Testilov", "comradeTestilov@testmail.com", "TestStreet 161"));
		testStudentList.add(new Student("Testan Testovic", "testanT@test.com", "TestStreet 1337"));
		
		testStudent = new Student("name", "mail@mail.com", "somestreet");

		testCourse = new Course("testCourse", LocalDate.now(), 1, testStudentList); 
		
	}

	@Test
	public void testGetters(){
		assertTrue(testCourse.getCourseName().equalsIgnoreCase("testcourse"));
		assertTrue(testCourse.getWeekDuration()==1);
		assertTrue(testCourse.getCourseDate().equals(LocalDate.now()));
		assertTrue(testCourse.getStudents().equals(testStudentList));
	}
	
	@Test 
	public void CourseDateNullShouldThrowException() {
		ArrayList<Student> testStudentList2 = new ArrayList<Student>();
		testStudentList2.add(new Student("name", "mail@mail.com", "adress street 1"));
		
		try{
			
			this.anotherTestCourse = new Course("testyCourse", null, 1, testStudentList2);
		}
		catch(Exception e) {
			//thats ok, it should throw NullPointerException
			assertTrue(this.anotherTestCourse ==null);
		} 
		
	}
	@Test
	public void testRegisterShouldAssertTrue() {
		testCourse.getStudents().clear();
		testStudent.getCourses().clear();
		assertTrue(testCourse.register(testStudent));
		assertTrue(testCourse.getStudents().contains(testStudent));
		assertTrue(testStudent.getCourses().contains(testCourse));
	}
	
	@Test
	public void registerNullStudentShouldThrowExc() {
		try {
			assertFalse(testCourse.register(null));
		} catch (Exception e) {			
			//That's ok, it should throw an NullPointerException
			//check if it contains a null pointer, don't want
			//that
			assertFalse(testCourse.getStudents().contains(null));
		}
	}
	
	@Test
	public void registeringSameStudentTwiceShouldAssertFalse() {
		testStudent.getCourses().clear();
		testCourse.getStudents().clear();
		testCourse.register(testStudent);
		assertFalse(testCourse.register(testStudent));
		
	}

	
	@Test
	public void testUnregisterShouldAssertTrue() {
		testCourse.getStudents().clear();
		testStudent.getCourses().clear();
		assertTrue(testCourse.register(testStudent));
		assertTrue(testCourse.unregister(testStudent));
		assertFalse(testCourse.getStudents().contains(testStudent));
		assertFalse(testStudent.getCourses().contains(testCourse));
	}
	
	@Test
	public void testUnregisterOnNullPointerShouldAssertFalse() {
		testCourse.getStudents().clear();
		testStudent.getCourses().clear();
		try {
			assertFalse(testCourse.unregister(null));
		}
		catch (Exception e) {
			assertFalse(testCourse.getStudents().contains(null));
		}
		
	}
	
	@Test
	public void removingUnregisteredStudentShouldAssertFalse() {
		testCourse.getStudents().clear();
		testStudent.getCourses().clear();
		try {
			assertFalse(testCourse.unregister(testStudent));
		}
		catch (Exception e) {
			assertFalse(testCourse.getStudents().contains(testStudent));
		}
		
	}
}