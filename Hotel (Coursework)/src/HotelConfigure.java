import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class HotelConfigure {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); //This scanner is used to get the name of the hotel
		Validate v = new Validate(); //Creates and object of the validate class
		//I originally did all my input validation in this class, but it looks much neater to use a separate class (Validate.java)

		System.out.println("Hotel name:");
		String hotelName = s.nextLine();
		
		
		int numberOfRooms = v.getValidIntegerInput("Number of rooms:", 1, 1000); //Makes sure the user enters an integer between 1 and 1000 inclusive
		//Without this validation, if the user entered a string, the program would throw an exception and crash
		//This assumes the user does not want a hotel with more than 1000 rooms
		
		Hotel h = new Hotel(hotelName, numberOfRooms); //Creates new Hotel object for the hotel

		for (int i = 1; i <= numberOfRooms; i++) {	//Executes the following code once for every room in the hotel	

			boolean vacant = v.getValidBooleanInput("\t Is room " + i + " vacant? (yes or no):"); //Gets valid input
			int numberOfBeds = v.getValidIntegerInput("\t (Room " + i + ") Number of beds:", 1, 4); //Assumes a maximum of 4 beds in 1 hotel room
			
			Room r = new Room(i, numberOfBeds, vacant); //Creates room object
			
			for (int x = 0; x < numberOfBeds; x++) { //For every bed in the room:

				int bedSize = v.getValidIntegerInput("\t\t Bed " + (x+1) + " size (1 or 2):", 1, 2);
				Bed b = new Bed(bedSize); //Get bed size (single or double) then creates the bed object
				
				r.addBed(b, x); //Add the bed object to the list of beds in the room object
			}
			h.addRoom(r, i-1); //Adds the room object to the list of rooms in the hotel object
		}


		HotelReport p = new HotelReport();

		p.display(h); //Calls the display method in the HotelReport.java class

		s.close(); //Close the scanner as it is not used again
	}


}
