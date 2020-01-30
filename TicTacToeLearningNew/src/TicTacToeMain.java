import java.util.Scanner;

/**
 * 
 */

/**
 * @author maxwi
 *
 */
public class TicTacToeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board board = new Board();
		boolean playerIsNext = true;
		System.out.println("Welcome to TicTacToe");
		for (int i = 0; i < 9; i++) {
			if (playerIsNext) {
				// input user
				System.out.println("Your turn! Choose an empty field!");
				Scanner in = new Scanner(System.in);
				int input;
				do {
					input = in.nextInt();
				} while (input < 0 || input > 8 || board.getField()[input] != ' ');
				board.setField(input, 'X');
				playerIsNext = false;
			} else {
				// computer
				board.setField(chooseField(board.getField()), 'O');
				playerIsNext = true;
			}
			board.printField();
			if (board.hasWon()) {
				if (playerIsNext) {
					System.out.println("PC has won!");
					i = 9;
					break;
				} else {
					System.out.println("Player has won!");
					i = 9;
					break;
				}
			}
		}

	}
	public static int chooseField(char field[]) {
		//logic
		return 1;
	}

}
