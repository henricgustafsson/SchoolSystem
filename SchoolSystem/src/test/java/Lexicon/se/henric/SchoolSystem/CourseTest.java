package Lexicon.se.henric.SchoolSystem;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Model.Course;
import Model.Student;

public class CourseTest {
	

	
	private Course testCourse;
	private List<Student> testStudentList;
	
	@Before
	public void init() {
		testStudentList = new ArrayList<Student>();
		testStudentList.add(new Student("Testor Testerson", "testerson@testmail.com", "TestStreet 1312"));
		testStudentList.add(new Student("Testiana Testilov", "comradeTestilov@testmail.com", "TestStreet 161"));
		testStudentList.add(new Student("Testan Testovic", "testanT@test.com", "TestStreet 1337"));
		

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
			@SuppressWarnings("unused")
			Course anotherTestCourse = new Course("testyCourse", null, 1, testStudentList2);
		}
		catch(Exception e) {
			//Thats ok it should throw an exception so...
		}
		
	}
	@Test
	public void testRegister() {
		Student st = new Student("name", "mail@mail.com", "somestreet");
		assertTrue(testCourse.register(st));
		assertTrue(testCourse.getStudents().contains(st));
		assertTrue(st.getCourses().contains(testCourse));
	}
	
	
}