
public class Board {
	private char field[] = new char[9];

	Board() {
		clearBoard();
	}

	void setField(int pos, char xOrO) {
		if (field[pos] == ' ') {
			field[pos] = xOrO;
		} else {
			System.out.println("Field " + pos + " is not empty! Choose another field!");
		}
	}

	char[] getField() {
		return field;
	}

	void printField() {
		System.out.println("");
		for (int i = 0; i < 9; i++) {
			System.out.print("[" + field[i] + "] ");
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
	}

	boolean tie(char checkField[]) {
		for (int i = 0; i < 9; i++) {
			if (checkField[i] == ' ') {
				return false;
			}
		}
		return true;
	}

	boolean hasWon(char checkField[]) {
		// checks rows
		if ((checkField[0] == checkField[1] && checkField[1] == checkField[2] && checkField[0] != ' ')
				|| (checkField[3] == checkField[4] && checkField[4] == checkField[5] && checkField[3] != ' ')
				|| (checkField[6] == checkField[7] && checkField[7] == checkField[8] && checkField[6] != ' ')

				// checks columns
				|| (checkField[0] == checkField[3] && checkField[3] == checkField[6] && checkField[0] != ' ')
				|| (checkField[1] == checkField[4] && checkField[4] == checkField[7] && checkField[1] != ' ')
				|| (checkField[2] == checkField[5] && checkField[5] == checkField[8] && checkField[2] != ' ')

				// checks diagonals
				|| (checkField[0] == checkField[4] && checkField[4] == checkField[8] && checkField[0] != ' ')
				|| (checkField[2] == checkField[4] && checkField[4] == checkField[6] && checkField[2] != ' ')) {

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
