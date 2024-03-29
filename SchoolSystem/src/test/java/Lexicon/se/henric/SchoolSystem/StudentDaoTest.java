package Lexicon.se.henric.SchoolSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Lexicon.se.henric.SchoolSystem.DAO.StudentDaoList;
import Model.Student;

public class StudentDaoTest {
	
	private StudentDaoList testStudentDaoList;
	private Student testStudent;

	@Before
	public void init() {
		testStudentDaoList = new StudentDaoList();
		testStudent = new Student("testian", "testian@testmail.com", "testStreet 1");
		
	}
	
	@Test
	public void SaveStudentWithValidStudentShouldAssertTrue() {
		testStudentDaoList.clearStudentList();
		assertTrue(testStudentDaoList.saveStudent(testStudent).equals(testStudent));
	}
	
	@Test
	public void SaveStudentNullParamShouldThrowNullPointer() {
		try {
			testStudentDaoList.saveStudent(null);
		}
		catch(Exception e) {
			//its ok, it should throw NullPointerException 
		}
	}

	@Test
	public void FindByEmailWitValidEmailSHouldAssertTrue() {
		testStudentDaoList.clearStudentList();
		testStudentDaoList.saveStudent(testStudent);
		assertTrue(testStudentDaoList.findStudentByEmail("testian@testmail.com").equals(testStudent));
	}
	
	@Test
	public void FindByEmailWithEmptyStringlSHouldThrowException() {
		testStudentDaoList.clearStudentList();
		testStudentDaoList.saveStudent(testStudent);
		try {
			testStudentDaoList.findStudentByEmail("");
		}
		catch(Exception e){
			//thats ok it should throw InvalidParameterException
		}
	}
	


	@Test
	public void FindByNameWithEmptyStringlSHouldThrowException() {
		
		try {
			testStudentDaoList.findStudentsByName("");
		}
		catch(Exception e){
			//thats ok it should throw InvalidParameterException
		}
	}
	
	@Test
	public void FindByNameWithValidNameShouldAssertTrue() {
		testStudentDaoList.clearStudentList();
		testStudentDaoList.saveStudent(testStudent);
		
		assertTrue(testStudentDaoList.findStudentsByName("testian").contains(testStudent));	
	}
	

	@Test
	public void FindByIDWithValidIDShouldAssertTrue() {
		testStudentDaoList.clearStudentList();
		int id =testStudentDaoList.saveStudent(testStudent).getId();
		
		assertTrue(testStudentDaoList.findStudentById(id).equals(testStudent));	
	}
	
	@Test
	public void FindByIDWithInValidIDShouldThrowException() {
			
		try {
			testStudentDaoList.findStudentById(25);
		} catch (Exception e) {
			//its ok it should throw IllegalStateException
		}	
	}
	
	@Test
	public void deleteExistingStudentShouldAssertTrue() {
		testStudentDaoList.clearStudentList();
		testStudentDaoList.saveStudent(testStudent);
		assertTrue(testStudentDaoList.deleteStudent(testStudent));
		
	}
	
	
	@Test
	public void deleteNonExistingStudentShouldAssertFalse() {
		testStudentDaoList.clearStudentList();
		
		assertFalse(testStudentDaoList.deleteStudent(testStudent));
		
	}
	
	


}
