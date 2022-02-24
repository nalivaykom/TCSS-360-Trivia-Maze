import java.util.*;

public class Maze {

	private Room[][] MazeRooms;
	
	Maze() {
		MazeRooms = new Room[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((i % 2 == 0) && (j % 2 == 0)) {
				    MazeRooms[i][j] = new Room();
				}    
			}
		}
	}
	
	 Room getRoom(int row, int column) {
		return MazeRooms[row][column];
	}
}
