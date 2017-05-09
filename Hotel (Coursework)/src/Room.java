import java.util.ArrayList;
import java.util.List;

public class Room {

	private int roomNumber;
	private int numberOfBeds;
	private boolean isVacant;
	private List<Bed> bedsList;
	

	Room(int roomNumber, int numberOfBeds, boolean vacant) {
		setRoomNumber(roomNumber);
		setNumberOfBeds(numberOfBeds);
		setVacancyStatus(vacant);
		bedsList = new ArrayList<Bed>(); //Initializes the list of beds
	}

	public int getRoomOccupancy() { //Gets the maximum occupancy of the room (used to calculate the max occupancy of the hotel in Hotel.java)
		int result = 0;

		for (int i = 0; i < bedsList.size(); i++) {
			Bed b = bedsList.get(i);
			result += b.getBedSize();
		}

		return result;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public boolean isVacant() {

		return isVacant;
	}

	public String getVacantString() {
		if (isVacant()) {
			return "Yes";
		} else {
			return "No";
		}
	}

	public void setVacancyStatus(boolean isVacant) {
		this.isVacant = isVacant;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Bed> getBedsList() {
		return bedsList;
	}

	public void addBed(Bed b, int index) { //Similar to the addRoom() method in Hotel.java
		bedsList.add(index, b); //Allows you to directly add a bed to the list from another class
	}

}
