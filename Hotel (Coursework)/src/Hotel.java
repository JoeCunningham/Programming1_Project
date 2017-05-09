import java.util.ArrayList;
import java.util.List;

public class Hotel {

	//These fields could be static because there is only ever going to be one instance of a hotel
	private String hotelName;
	private int numberOfRooms;
	private boolean hasVacancies;
	private List<Room> roomsList; //List containing room objects


	Hotel (String hotelName, int numberOfRooms) {
		setHotelName(hotelName);
		setNumberOfRooms(numberOfRooms);
		roomsList = new ArrayList<Room>(); //Initialize list of rooms
	}

	public int getHotelOccupancy() { //This method calculates the maximum occupancy of the hotel
		int result = 0;

		for (int i = 0; i < roomsList.size(); i++) { //Iterates through every room to get the max occupancy
			Room r = roomsList.get(i);
			result += r.getRoomOccupancy();
		}

		return result;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String getHotelVacantString() { //This method returns the hasVacancies boolean as a String
		String result = ""; 			   //So the result of this method can be directly output as either "Yes" or "No"
		if (hasVacancies()) {			   //Rather than "true" or "false", so it's easier for the user to read
			result = "Yes";
		} else {
			result = "No";
		}
		return result;
	}

	public boolean hasVacancies() { //This method iterates through every room in the list
		for (int i = 0; i < roomsList.size(); i++) { //And if one room is vacant, then hasVacancies is set to true
			Room r = roomsList.get(i);
			if (r.isVacant()) {
				hasVacancies = true;
			}
		}
		return hasVacancies;
	}

	public List<Room> getRoomsList() {
		return roomsList;
	}

	public void addRoom(Room r, int index) { //This method allows you to add a room object directly into the list from another class
		roomsList.add(index, r); //Without having to create an instance of the list
	}

}
