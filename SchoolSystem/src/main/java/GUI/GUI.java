package GUI;

import Lexicon.se.henric.SchoolSystem.DAO.SchoolSystemDao;

public class GUI {

	private OutPutHandler OutPutHandler;
	private InputHandler inputHandler;
	private SchoolSystemDao DAO;

	public GUI() {
		inputHandler = new InputHandler();
		OutPutHandler = new OutPutHandler();
		DAO = new SchoolSystemDao();
	}
	
	public String createNewStudentAndSave() {
		//OutPutHandler.outPutMessage("");
	}
}
