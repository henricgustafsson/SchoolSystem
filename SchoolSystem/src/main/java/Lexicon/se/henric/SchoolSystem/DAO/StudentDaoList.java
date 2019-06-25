package Lexicon.se.henric.SchoolSystem.DAO;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



import Model.Student;

public class StudentDaoList implements StudentDao{
	
	private static List<Student> students;
	
	public StudentDaoList() {
		students = new ArrayList<Student>();
	}

	@Override
	public Student saveStudent(Student student) {
		if(student !=null) {
			if(!students.contains(student) && students.add(student)) {
				return student;
			}
			
		}
		throw new NullPointerException();
	}

	@Override
	public Student findStudentByEmail(String email) {
		
		if (!email.trim().isEmpty()) {
			List <Student> results =students.stream()
			.filter(student->student.getEmail().equals(email))
			.collect(Collectors.toList());
			
			if(results.size() >1 || results.isEmpty()) {
				throw new IllegalStateException("Invalid number of results returned");
			}
			
			return results.get(0);
		}
		throw new InvalidParameterException("Invalid imput, please try again");
				
	}

	@Override
	public List<Student> findStudentsByName(String name) {
		if(!name.isEmpty()) {
			
			return students.stream()
					.filter(student->student.getFullName().equals(name))
					.collect(Collectors.toList());
		}
		
		throw new InvalidParameterException("Invalid imput, please try again");
	}

	@Override
	public Student findStudentById(int id) {
		
		List <Student> results =students.stream()
				.filter(student->student.getId()==id)
				.collect(Collectors.toList());
				
				if(results.size() >1 || results.isEmpty()) {
					throw new IllegalStateException("Invalid number of results returned");
				}
				
				return results.get(0);
		
	}
	
	public List<Student> getAllStudents(){
		return students;
	}

	@Override
	public boolean deleteStudent(Student student) {
		
		return students.remove(student);
	}
	
	
	public void clearStudentList() {
		students.clear();
	}
}
