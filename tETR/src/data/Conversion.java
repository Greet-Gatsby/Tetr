package data;

public class Conversion {
	//preobrazovanie
	
	public static int cellToCoord(int cell) {	
		//kletki
		return cell * 32;
	}

	public static int coordToCell(int coord) {	
		//ploskosti
		return coord / 32;
	}
}
