package Lexicon.se.henric.SchoolSystem.DAO;

import java.util.List;
import java.util.Map;

import Model.Student;

public interface StudentDao {

	Student saveStudent(Student student);
	Student findByEmail(String email);
	List<Student> findByName(String name);
	Student findById(int id);
	boolean deleteStudent(Student student);
	
}
