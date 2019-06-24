package GUI;

import Lexicon.se.henric.SchoolSystem.DAO.SchoolSystemDao;
import Lexicon.se.henric.SchoolSystem.DAO.StudentDao;
import Model.Student;

public class GUI {

	private OutPutHandler outputHandler;
	private InputHandler inputHandler;
	private SchoolSystemDao DAO;

	public GUI() {
		
		outputHandler = new OutPutHandler();
		inputHandler = new InputHandler(outputHandler);
		DAO = new SchoolSystemDao();
	}
	
//	public String createNewStudentAndSave() {	
//		boolean validInput = false;
//		String name;
//		String email;
//		String adress;
//		Student student;
//		do {
//			try {
//				 name = inputHandler.getStringInput("Input name");
//				 email= inputHandler.getStringInput("Input email");
//				 adress = inputHandler.getStringInput("Input adress");
//				 student = DAO.saveStudent(new Student(name, email, adress));
//			} catch (Exception e) {
//				outputHandler.outPutMessage("Invalid input");
//			} 
//		} while (validInput);
//		
//		return null;
//	}
}
