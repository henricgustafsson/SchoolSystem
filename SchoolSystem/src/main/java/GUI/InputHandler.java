package GUI;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHandler {

	Scanner sc;
	
	public InputHandler() {
		sc = new Scanner(System.in);
	}
	public String getStringInput() {
		return sc.nextLine();
	}
	public LocalDate getInputAsDate() {
		String input =sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date;
		
		return LocalDate.parse(input, formatter);
	}
	public int getInputAsInt() {
		return sc.nextInt();
	}
}
