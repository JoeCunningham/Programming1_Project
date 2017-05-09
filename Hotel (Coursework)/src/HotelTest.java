import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import java.util.ArrayList;

public class HotelTest {
	//This class has an alternate main method, and is used to test the functionality of the program
	//Rather than requiring the user to input values, it generates random numbers for the number of rooms and beds
	public static void main(String[] args) {
		int maxRooms = 5; //Sets the maximum number of rooms (the random value will be between 0 and this number)
		int maxBeds = 2; //Sets the maximum  number of beds in each room
		int numberOfRooms = ThreadLocalRandom.current().nextInt(1, maxRooms+1);

		Hotel h = new Hotel("Test Hotel", numberOfRooms);
		List<Room> roomsList = new ArrayList<Room>();

		for (int i = 0; i < numberOfRooms; i++) {
			int numberOfBeds = 	ThreadLocalRandom.current().nextInt(1, maxBeds+1);
			int bedSize = ThreadLocalRandom.current().nextInt(1, 3);
			boolean vacant  = ThreadLocalRandom.current().nextBoolean();
			roomsList.add(i, new Room((i+1), numberOfBeds, vacant));
			for (int x = 0; x < numberOfBeds; x++) {
				Bed b = new Bed(bedSize); 
				roomsList.get(i).addBed(b, x);
			}
			h.addRoom(roomsList.get(i), i);;
		}

		HotelReport hr = new HotelReport();
		hr.display(h); //Prints report for this test data, showing that the program works and can calculate the maximum occupancy


	}

}
