import java.util.List;
import java.util.ArrayList;

public class HotelReport {

	public void display(Hotel h) { //This method prints out a report containing information about the hotel and each room
		//The parameter for the method is the hotel object (for the hotel which the report is about)
		
		
		List<Room> roomsList = new ArrayList<Room>();
		roomsList = h.getRoomsList(); //Gets the list of rooms contained in the hotel object
		
		System.out.println("\n \n \n");
		System.out.println("Hotel name: " + h.getHotelName()); //These statements print out the information for the hotel
		System.out.println("Number of rooms: " + h.getNumberOfRooms()); //Using getters in the Hotel.java class
		System.out.println("Maximum hotel occupancy: " + h.getHotelOccupancy());
		System.out.println("Vacancies: " + h.getHotelVacantString());
		System.out.println("\n");

		for (int i = 0; i < h.getNumberOfRooms(); i++) { //Prints out the following information for every room in the list
			System.out.println("ROOM " + (i+1));
			System.out.println("Vacant: " + roomsList.get(i).getVacantString());
			System.out.println("Number of beds: " + roomsList.get(i).getNumberOfBeds());
			System.out.println("Max room occupancy: " + roomsList.get(i).getRoomOccupancy());
			for (int x = 0; x < roomsList.get(i).getNumberOfBeds(); x++) {
				List<Bed> b2 = roomsList.get(i).getBedsList();
				System.out.println("Bed " + (x+1) + " size: " + b2.get(x).getBedSizeString());
			}
			System.out.println("\n");
		}

	}

}
