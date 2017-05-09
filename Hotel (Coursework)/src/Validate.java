import java.util.Scanner;

public class Validate {
	//This class simply validates the input from the user from the scanner
	//This class avoids any exceptions (for example, from the user inputting a String instead of an integer)
	//(Which would throw an InputMismatchException)
	
	
	boolean error = false;
	
	public int getValidIntegerInput(String consoleMessage, int minimum, int maximum) {
		//consoleMessage is the message that is output to the user (asking for input)
		//minimum and maximum specify the range of values which the user is allowed to input
		
		int result = 0;

		do { //Continue to execute the following code as long as there is an error
			Scanner scan = new Scanner(System.in);
			System.out.println(consoleMessage);
			if (scan.hasNextInt()) {
				int input = scan.nextInt();
				if (input >= minimum && input <= maximum) { //The input is within the range of values
					result = input; 
					error = false;
				} else { //The number the user entered is outside of the range of values
					System.out.println("Please enter a number between " + minimum + " and " + maximum + " (inclusive) \n");
					error = true; //There is an error, so the do... while loop must continue to execute
				}
			} else { //The user has not typed in an integer (hasNextInt() == false)
				System.out.println("Please enter a valid integer \n");
				error = true;
			}
		}
		while (error);

		return result;
	}
	
	public boolean getValidBooleanInput(String consoleString) {
		boolean result = false;
		
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println(consoleString);
			String vacantStr = scan.nextLine();
			if (vacantStr.toLowerCase().equals("yes")) { //Checks that the user has entered either 'yes' or 'no'
				result = true;
				error = false;
			} else if (vacantStr.toLowerCase().equals("no")) { 
				result = false;
				error = false;
			} else {
				error = true; //There is an error, because the user has not entered yes or no
			}
		} while (error);
		
		return result;
	}
	
	
}
