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
		for (int i = 0; i < 9; i++) {
			System.out.println("Round :" + i);
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
				// board.setField(chooseField(board.getField(), board), 'O');
				board.setField(bestMove(board), 'O');
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

	public static int bestMove(Board board) {
		int score;
		int bestMove = 0;
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
					bestMove = i;
				}
			}
		}
		return bestMove;
	}

	public static int minimax(Board board, boolean isMaximizing, char[] testField) {
		if (board.hasWon(testField)) {
			int score;
			if (isMaximizing) {
				score = 1;
			} else {
				score = -1;
			}
			return score;
		}
		if (board.tie(testField)) {
			return 0;
		}
		if (isMaximizing) {
			int score = -1;
			int bestScore = -1;
			for (int i = 0; i < 9; i++) {
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
			int score = 1;
			int bestScore = 1;
			for (int i = 0; i < 9; i++) {
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

//	public static int chooseField(char field[], Board board) {
//		// logic
//		boolean playerIsNext = false;
//		double moveEvaluation[] = scanForBestMove(field, board, playerIsNext);
//		int pointer = 0;
//		for (int i = 0; i < 9; i++) {
//			System.out.println(moveEvaluation[i]);
//			if (moveEvaluation[pointer] < moveEvaluation[i]) {
//				pointer = i;
//			}
//		}
//		System.out.println("pointer: " + pointer);
//		return pointer;
//	}

//	public static double[] minimax(char field, Board board, boolean playerIsNext) {
//		char field2[] = new char[9];
//
//	}

//	public static double[] scanForBestMove(char field[], Board board, boolean playerIsNext) {
//		char testField[]=new char[9];
//		double bestMove[] = new double[9];
//		for(int k=0;k<9;k++) {
//			bestMove[k]=0;
//			//field is not empty
//			
//			testField[k]=field[k];
//		}
//		for (int i = 0; i < 9; i++) {
//			if (testField[i] == ' ') {
//				double help[];
//				if (playerIsNext) {
//					testField[i] = 'X';
//					help=scanForBestMove(testField, board, false);
//				} else {
//					testField[i] = 'O';
//					help=scanForBestMove(testField, board, true);
//				}
//				if (board.hasWon(testField)) {
//					if (playerIsNext) {
//						bestMove[i] = 1;
//					} else {
//						bestMove[i] = 1;
//					}
//
//				} else {
//					testField[i] = ' '; //resets the move
//					for(int k=0;k<9;k++) {
//						bestMove[i]=bestMove[i]+help[k]/9.0;
//					}
//				}
//			}
//
//		}
//		return bestMove;
//	}

}
