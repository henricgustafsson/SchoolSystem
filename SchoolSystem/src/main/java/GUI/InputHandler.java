package GUI;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Consumer;


public class InputHandler {

	private Scanner sc;
	
	
	public InputHandler() {
		sc = new Scanner(System.in);
		
		
	}
	public String getStringInput(String message,Consumer<String> outputHandler) {
		outputHandler.accept(message);
		return sc.nextLine();
	}
	public LocalDate getInputAsDate(String message,Consumer<String> outputHandler) {
		outputHandler.accept(message);
		String input =sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		
		return LocalDate.parse(input, formatter);
	}
	public int getInputAsInt(String message,Consumer<String> outputHandler) {
		outputHandler.accept(message);
		return sc.nextInt();
	}
	
	
}
