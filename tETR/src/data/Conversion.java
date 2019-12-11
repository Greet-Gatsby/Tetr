package data;

public class Conversion {
	//реобразование
	
	public static int cellToCoord(int cell) {	
		//клетки
		return cell * 32;
	}

	public static int coordToCell(int coord) {	
		//плоскости
		return coord / 32;
	}
}
