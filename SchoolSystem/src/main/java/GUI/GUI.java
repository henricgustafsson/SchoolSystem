package GUI;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Lexicon.se.henric.SchoolSystem.DAO.SchoolSystemDao;
import Model.Course;
import Model.Student;
@SuppressWarnings("unused")
public class GUI {

	private InputHandler inputHandler;
	private SchoolSystemDao DAO;
	private Consumer<String> outputHandler = System.out::println;
	
	private UnaryOperator<String> getStringInput;
	private Function<String, LocalDate> getLocalDateInput;
	private Function<String,Integer> getIntInput;
	
	private UnaryOperator<Student> saveStudent;
	private Function<String, Student> findStudentByEmail;
	private Function<Integer, Student> findStudentByID;
	private Function<String,List<Student>> findStudentsByName;
	
	private Function<LocalDate, List<Course>> findCoursesByDate;
	private Function<Integer, Course> findCourseByID;
	private Function<String, List<Course>> findCoursesByName;
	private UnaryOperator<Course> saveCourse;
	
	private final static String STUDENT_FIND_OPTIONS="1.By id\2.By Email";
	
	
	/**
	 * Constructor
	 */
	public GUI() {
		//Creates a new inputHandler instance with
		//@Param Consumer<String> outputHandler (see field Consumer<String> outputHandler)
		inputHandler = new InputHandler();
		//Creates a new schoolsystemDAO instance
		DAO = new SchoolSystemDao();
		
		//Input functions with @param Consumer<String> outputHandler calling
		//functions in GUI.inputHandler
		getStringInput = message->inputHandler.getStringInput(message, outputHandler);
		getLocalDateInput = message -> inputHandler.getInputAsDate(message, outputHandler);
		getIntInput = message-> inputHandler.getInputAsInt(message, outputHandler);
		//Functions for finding student by calling methods in SchoolSystem.DAO
		//@RETURN student
		findStudentByEmail = email ->DAO.findStudentByEmail(email);
		findStudentByID = id ->DAO.findStudentById(id);
		//Function for finding students by name by calling SchoolSystem.DAO.findStudentsByName
		//@RETURN list<Student>
		findStudentsByName = name->DAO.findStudentsByName(name);		
		//Function for saving student by calling DAO.saveStudent
		//@RETURN Student
		saveStudent = student-> DAO.saveStudent(student);
		//Same but with course
		findCoursesByDate = date-> DAO.findCoursesByDate(date);
		findCourseByID =id->DAO.findCourseById(id);
		findCoursesByName = name->DAO.findCoursesByName(name);
		saveCourse = course->DAO.saveCourse(course);
		
		
	}
	
	public String createNewStudentAndSave() {			
			
		return saveStudent.apply(createNewStudent())
				.toString();
		
	}
	
	private Student createNewStudent() {
		
		return	new Student(
					getStringInput.apply("Enter name:"), 
					getStringInput.apply("Enter email:"),
					getStringInput.apply("Enter adress:")
					);
	}
	
	
	public String findStudentByName() {
		return findStudentsByName.apply(getStringInput.apply("Enter name:"))
				.stream()
				.map((s)->s.toString())
				.collect(Collectors.joining("\n"));
	}
	

	public String findStudentByEmail() {
		return findStudentByEmail.apply(getStringInput.apply("Enter email"))
				.toString();
	}
	
	public String findStudentByID() {
		return findStudentByID.apply(getIntInput.apply("Enter ID:"))
				.toString();
	}

	public String findAllCourses() {
		return DAO.findAllCourses()
				.stream()
				.map((c)->c.toString())
				.collect(Collectors.joining("\n"));
	}

	public String findCoursesByName() {
		return findCoursesByName.apply(getStringInput.apply("Enter name"))
				.stream()
				.map((c)->c.toString())
				.collect(Collectors.joining("\n"));
	}
	
	public String findCoursesByDate() {
		return findCoursesByDate.apply(getLocalDateInput.apply("Enter Date"))
			   .stream()
			   .map((c)->c.toString())
			   .collect(Collectors.joining("\n"));
	}
	
	public String findCourseByID() {
		return findCourseByID.apply(getIntInput.apply("Enter id"))
				.toString();
	}

	private List<Student> createNewStudentList(int numberOfStudents) {
		List<Student> students = new ArrayList<Student>();
		int i=0;
		while(i <=numberOfStudents) {			
			chooseFindMethodAndAddToList(students);
			i++;
		}
		return students;
	}
	
	private void chooseFindMethodAndAddToList(List<Student> listToAddTo) {
		outputHandler.accept(STUDENT_FIND_OPTIONS);
		switch (getIntInput.apply("Choose Method of finding a student:"))
		{
		case 1:
			listToAddTo.add(findStudentByID.apply(getIntInput.apply("Enter ID:")));
			break;
		case 2:
			listToAddTo.add(findStudentByEmail.apply(getStringInput.apply("Enter email:")));
		//One can a add more options if more functionality is added but for now these
		//are all the options we we have that can find a specific student
		//by unique identifier
		default:
			break;
		}
		
	}
	
	
	private Course createNewCourse() {
		return new Course(
					getStringInput.apply("Input name:"),
					getLocalDateInput.apply("Input course date:"),
					getIntInput.apply("Input course duration:"),
					createNewStudentList(getIntInput.apply("How many students do"
							 						+"you want to find and add?"))
					);
	}
	
	
	public String createNewCourseAndSave() {			
		
		return saveCourse.apply(createNewCourse())
				.toString();
		
	}
	
	
	public String editStudent() {
		return null
				//findCourseByID.apply("Enter ID:") und so weiter
	}
	
	
		
	
	
}
