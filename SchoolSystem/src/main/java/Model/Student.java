package Model;

import java.util.*;
import java.util.regex.Pattern;



/**
 * @author Henric Gustafsson
 *
 */
public class Student implements Comparable<Student> {

	private static int COUNTER =0;
	private int id;
	private String name;
	private String email;
	private String address;
	private List<Course> courses;
	
	public Student(String name, String email, String adress) {
		
		setId(++COUNTER);
		setName(name);
		setEmail(email);		
		setAdress(adress);
	
		this.courses = new ArrayList<Course>();
		
		
	}

	/** Getter for field int id
	 * @return field int id
	 */
	public int getId() {
		return id;
	}

	/** Setter for field int id
	 * @param int id
	 */
	private void setId(int id) {
		this.id = id;
	}

	/** Getter for field String Name
	 * @return field String Name
	 */
	public String getFullName() {
		return name;
	}

	/** Setter for field String name
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**getter for field String email
	 * @return field String email
	 */
	public String getEmail() {
		return email;
	}

	/** setter for field String email
	 * @param String email
	 * @throws InvalidAttributeValueException 
	 */
	public void setEmail(String email) {
		//From: https://www.owasp.org/index.php/OWASP_Validation_Regex_Repository
		
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
			Pattern pattern = Pattern.compile(emailRegex); 
		
			if(pattern.matcher(email).matches()) {
				this.email = email;
			}
		
		//can't be bothered with exception-handling so set it to empty string
		//better than null pointer at least
		else this.email ="";
		
	}

	/** getter for field String address
	 * @return field String address
	 */
	public String getAdress() {
		return address;
	}

	/** setter for field String address
	 * @param String address
	 */
	public void setAdress(String adress) {
		this.address = adress;
	}

	/** getter for field List<Course> courses
	 * @return field List<Course> courses
	 */
	public List<Course> getCourses() {
		return courses;
	}
	
	/** TODO: CompareTo is only needed if student objects need to be compared,
	 * 
	 * Implementation of abstract method comparable<student>.compareTo
	 */
	public int compareTo(Student o) {
		
		return o.name.compareToIgnoreCase(o.name);
	}
	
	/**
	 *  Overriden hashCode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + id;
		return result;
	}

	
	
	
	/**
	 * Overriden equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
