import java.util.*;

public class Maze {

	private Room[][] MazeRooms;
	
	Maze() {
		MazeRooms = new Room[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				MazeRooms[i][j] = new Room();
			}
		}
	}
	
	 Room getRoom(int row, int column) {
		return MazeRooms[row][column];
	}
}
