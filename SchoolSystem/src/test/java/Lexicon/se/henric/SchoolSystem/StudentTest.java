package Lexicon.se.henric.SchoolSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Model.Course;
import Model.Student;

public class StudentTest {

	private Student testStudent;

	private int testStudentId;
	private String testStudentName;
	private String testStudentAddress;
	@Before
	public void init() {
						
		testStudentName ="Testy McTeston";
		testStudentAddress = "TestStreet 420";
		testStudent = new Student(testStudentName, "mcteston@test.com", testStudentAddress);
		testStudentId = testStudent.getId();
		
		
	}
	
	@Test
	public void invalidEmailShouldReturnEmptyString() {
		Student testStudentWithWierdEmail = new Student("Testelina Testdottir", "asdsadsadsa","StreetName 1234");
		assertEquals(testStudentWithWierdEmail.getEmail(), "");
	
	}

	@Test
	public void testStudentGetters() {
		assertTrue(testStudent.getId() == testStudentId);
		assertTrue(testStudent.getFullName().equalsIgnoreCase(testStudentName));
		assertTrue(testStudent.getAdress().equalsIgnoreCase(testStudentAddress));
		assertTrue(testStudent.getEmail().equalsIgnoreCase("mcteston@test.com"));
	
	}
	
	
	
	
	
}
