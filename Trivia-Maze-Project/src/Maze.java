import java.util.*;

public class Maze {

	protected Maze() {
		Room[][] MazeRooms = new Room[7][7];
		
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				MazeRooms[i][j] = new Room();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}

}
