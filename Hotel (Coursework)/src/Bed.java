
public class Bed {

	private int bedSize;

	Bed (int bedSize) {
		setBedSize(bedSize);
	}


	public int getBedSize() {
		return bedSize;
	}

	public String getBedSizeString() { //Returns the bed size a a String either "Single" or "Double"
		String result = "";			   //Easier for the user to understand than "1" or "2"
		if (getBedSize() == 1) {	   //getBedSize() can only ever return 1 or 2 because of the input validation
			result = "Single";
		} else if (getBedSize() == 2) {
			result = "Double";
		}
		return result;
	}

	public void setBedSize(int bedSize) {
			this.bedSize = bedSize; 
	}

}
