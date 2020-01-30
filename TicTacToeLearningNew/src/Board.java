
public class Board {
	char field[] = new char[9];

	Board() {
		clearBoard();
	}
	
	void setField(int pos, char xOrO){
		if(field[pos] == ' ') {
			field[pos] = xOrO;
		} else {
			System.out.println("Field "+pos+" is not empty! Choose another field!");
		}
	}
	
	char[] getField(){
		return field;
	}
	
	void printField() {
		System.out.println("");
		for(int i=0;i<9;i++) {
			System.out.print("["+field[i]+"] ");
			if((i+1)%3==0) {
				System.out.println();
			}
		}
	}

	boolean hasWon() {
		//checks rows
		if ((field[0] == field[1] && field[1] == field[2] && field[0] != ' ')
				|| (field[3] == field[4] && field[4] == field[5] && field[3] != ' ')
				|| (field[6] == field[7] && field[7] == field[8] && field[6] != ' ')
				
				//checks columns
				|| (field[0] == field[3] && field[3] == field[6] && field[0] != ' ')
				|| (field[1] == field[4] && field[4] == field[7] && field[1] != ' ')
				|| (field[2] == field[5] && field[5] == field[8] && field[2] != ' ')
				
				//checks diagonals
				|| (field[0] == field[4] && field[4] == field[8] && field[0] != ' ')
				|| (field[2] == field[4] && field[4] == field[6] && field[2] != ' ')) {
			
			return true;
		} else {
			return false;
		}
	}
	
	void clearBoard() {
		for (int i = 0; i < 9; i++) {
			field[i] = ' ';
		}
	}
}
