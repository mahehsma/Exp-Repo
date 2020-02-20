import java.util.Scanner;

/**
 * 
 */

/**
 * @author mahehsma
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
		board.printField();
		for (int i = 0; i < 9; i++) {
//			System.out.println("Round :" + i);
			if (playerIsNext) {
				// input user
				System.out.println("Your turn! Choose an empty field!");
				Scanner in = new Scanner(System.in);
				int input;
				do {
					input = in.nextInt();
					if(input >= 0 && input <= 8 && board.getField()[input] != ' ') {
						System.out.println("This field is already used! Choose another!");
						board.printField();
					}
				} while (input < 0 || input > 8 || board.getField()[input] != ' ');
				board.setField(input, 'X');
				playerIsNext = false;
			} else {
				// pc / algorithm
				bestMove(board);
				playerIsNext = true;
			}
			board.printField();
			if (board.hasWon(board.getField())) {
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
		if (!board.hasWon(board.getField())) {
			System.out.println("Draw!");
		}

	}

	public static void bestMove(Board board) {
		/*	
		 * searches for best move for pc (best possible --> win = 1)
		 */
		int score;
		int move = 0; //position with best outcome
		int bestScore = -1;
		char[] testField = new char[9];
		for (int i = 0; i < 9; i++) {
			testField[i] = board.getField()[i];
		}
		for (int i = 0; i < 9; i++) {
			if (testField[i] == ' ') {
				testField[i] = 'O';
				score = minimax(board, false, testField);
				testField[i] = ' ';
				if (score > bestScore) {
					bestScore = score;
					move = i;
				}
			}
		}
		board.setField(move, 'O');
	}

	public static int minimax(Board board, boolean isMaximizing, char[] test) {
		char testField[] = new char[9];
		for(int i=0;i<9;i++) {
			testField=test;
		}
		if (board.hasWon(testField)) {
			if (isMaximizing) {
				//bad score gets returned because the player did the last move
				return -1;
			} else {
				//good score gets returned because the pc / algorithm did the last move
				return 1;
			}
		}
		if (board.tie(testField)) {
			//nobody has won
			return 0;
		}
		// pc is trying to maximize, searches for move with best outcome 
		if (isMaximizing) {
			int score;
			int bestScore = -1;
			for (int i = 0; i < 9; i++) {
				// puts an 'O' on position 'i' if empty, evaluates the outcome and undo it
				if (testField[i] == ' ') {
					testField[i] = 'O';
					score = minimax(board, false, testField);
					testField[i] = ' ';
					if (score > bestScore) {
						bestScore = score;
					}
				}
			}
			return bestScore;
		} else {
			// assuming the player is doing best possible move, the algorithm searches for worst possible move for the pc
			int score;
			int bestScore = 1;
			for (int i = 0; i < 9; i++) {
				// puts an 'X' on possition 'i' if empty, evaluates the outcome and undo it
				if (testField[i] == ' ') {
					testField[i] = 'X';
					score = minimax(board, true, testField);
					testField[i] = ' ';
					if (score < bestScore) {
						bestScore = score;
					}
				}
			}
			return bestScore;
		}
	}
}
