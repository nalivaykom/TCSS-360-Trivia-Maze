public class Maze {

	private Room[][] myMazeRooms;
	
	Maze() {
		myMazeRooms = new Room[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((i % 2 == 0) && (j % 2 == 0)) {
				    myMazeRooms[i][j] = new Room();
				}    
			}
		}
	}
	
	 Room getRoom(int theRow, int theColumn) {
		return myMazeRooms[theRow][theColumn];
	}
}
