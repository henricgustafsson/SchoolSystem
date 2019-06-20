package Lexicon.se.henric.SchoolSystem.DAO;

import java.util.List;
import java.util.Map;

import Model.Student;

public interface StudentDao {

	Student saveStudent(Student student);
	Student findStudentByEmail(String email);
	List<Student> findStudentByName(String name);
	Student findStudentById(int id);
	boolean deleteStudent(Student student);
	
}
