package GUI;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class InputHandler {

	Scanner sc;
	private OutPutHandler outputHandler;
	
	public InputHandler(OutPutHandler output) {
		sc = new Scanner(System.in);
		outputHandler = output;
	}
	public String getStringInput(String message) {
		outputHandler.outPutMessage(message);
		return sc.nextLine();
	}
	public LocalDate getInputAsDate(String message) {
		outputHandler.outPutMessage(message);
		String input =sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		
		return LocalDate.parse(input, formatter);
	}
	public int getInputAsInt(String message) {
		outputHandler.outPutMessage(message);
		return sc.nextInt();
	}
	
	
}
