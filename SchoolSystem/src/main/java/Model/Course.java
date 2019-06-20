package Model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Henric Gustafsson
 *
 */
/**
 * @author deltagare
 *
 */
public class Course implements StudentCourseRelationsShipInterface{

	private static int COUNTER=0;
	private int id;
	private String courseName;
	private LocalDate courseDate;
	private int weekDuration;
	private List<Student> students;
	
	
	
	public Course(String courseName, LocalDate courseDate, int weekDuration, List<Student> students) {
		setId(++COUNTER);
		setCourseName(courseName);
		setCourseDate(courseDate);
		setWeekDuration(weekDuration);		
		this.students = students;
	}

	/** getter for field String courseName
	 * @return field String courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/** setter for field String courseName
	 * @param String courseName
	 */
	private void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	/** getter for field LocalDate courseDate
	 * @return field LocalDate courseDate
	 */
	public LocalDate getCourseDate() {
		return courseDate;
	}
	
	
	/** setter for field LocalDate courseDate
	 * @param LocalDate courseDate
	 */
	private void setCourseDate(LocalDate courseDate) {
		//check if the given date is referring to an instance of Datetime and not just null
		if(courseDate!=null) {
			this.courseDate = courseDate;
		}
		else {
			throw new NullPointerException();
		}
	}
	
	
	/** getter for field int weekDuration
	 * @return field int weekDuration
	 */
	public int getWeekDuration() {
		return weekDuration;
	}
	
	/** setter for field int weekDuration
	 * @param int weekDuration
	 */
	private void setWeekDuration(int weekDuration) {
		this.weekDuration = weekDuration;
	}
	
	
	/** getter for field List<Student> students
	 * @return List<Student> students
	 */
	public List<Student> getStudents() {
		return students;
	}
	
	
	/** setter for field int id
	 * @param int id
	 */
	private void setId(int id) {
		this.id = id;
	}

	
	
	
	/**
	 * Overriden method implementing StudentCourseRelationShip interface
	 * for registering a student to a course
	 * @Param Student student
	 * @return boolean
	 */
	@Override
	public boolean registerStudentToCourse(Student student) {
		
		if(student==null) {
			throw new NullPointerException();
		}
		if(!students.contains(student)) {
			if(students.add(student)) {
				return student.getCourses().add(this);
			}
			
		}
		return false;
	

	}

	/**
	 * Overriden method implementing StudentCourseRelationShip interface
	 * for unregistering a student to a course
	 */
	@Override
	public boolean unregisterStudentFromCourse(Student student) {
		if(student==null) {
			throw new NullPointerException();
		}
		if(students.contains(student)) {
			if(students.remove(student)) {
				return student.getCourses().remove(this);
			}
			
		}
		return false;
	}
	
	
	
	/**
	 * Overriden hashCode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseDate == null) ? 0 : courseDate.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + id;
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + weekDuration;
		return result;
	}

	
	
	/**
	 *Overriden equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseDate == null) {
			if (other.courseDate != null)
				return false;
		} else if (!courseDate.equals(other.courseDate))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (id != other.id)
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		if (weekDuration != other.weekDuration)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	
	
	
	
}
