import java.util.Scanner;

public class TicTacMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Willkommen zu TicTacToe!\n (1) Soll der PC beginnen?\n (2) Willst du beginnen?");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		boolean pcOrPlayer;
		if (input == 1) {
			pcOrPlayer = true;
		} else {
			pcOrPlayer = false;
		}
		int XO[] = new int[9];
		XO = resetGame(XO);
		for (int i = 0; i < 9; i++) {
			if (pcOrPlayer == true) {
				System.out.println("PC setzt!");
				int set = 0;
				int pcSet = pcChoose(XO, pcOrPlayer, set);
				XO[pcSet] = 1;
				pcOrPlayer = false;
			} else {
				System.out.println("Wähle ein Feld (0-8)");
				do {
					input = in.nextInt();
				} while (!(XO[input] == 0 || input > 8 || input < 0));
				XO[input] = 4;
				pcOrPlayer = true;
			}
			createGrid(XO);
			boolean win = hasWon(XO);
			if (win == true && pcOrPlayer == true) {
				System.out.println("Spieler hat gewonnen!");
				break;
			} else if (win == true && pcOrPlayer == false) {
				System.out.println("PC hat gewonnen!");
				break;
			}
		}
	}

	public static int pcChoose(int XO[], boolean pcOrPlayer, int set) {
		int XOminimax[] = new int[9];
		int thisField[] = new int[9];
		for (int i = 0; i < 9; i++) {
			XOminimax[i] = XO[i];
		}
		for (int i = 0; i < 9; i++) {
			if (XOminimax[i] == 0) {
				if (pcOrPlayer == true) {
					XOminimax[i] = 1;
					pcOrPlayer = false;
				} else {
					pcOrPlayer = true;
					XOminimax[i] = 4;
				}
				if (hasWon(XOminimax) == true) {
					if (pcOrPlayer == false) {
						set = -1;
					} else if (pcOrPlayer == true) {
						set = 1;
					}
				} else if (i == 8) {
					set = 0;
				} else {
					thisField[i] = pcChoose(XOminimax, pcOrPlayer, set);
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (thisField[i] >= 1) {
				set = i;
			} else {
				set =0;
			}
		}
		System.out.println(set);
		return set;
	}

	public static boolean hasWon(int XO[]) {
		for (int i = 0; i < 2; i++) {
			int x = 9 * i + 3;
			if (((XO[0] + XO[1] + XO[2]) == x) || ((XO[3] + XO[4] + XO[5]) == x) || ((XO[6] + XO[7] + XO[8]) == x)
					|| ((XO[0] + XO[3] + XO[6]) == x) || ((XO[1] + XO[4] + XO[7]) == x)
					|| ((XO[2] + XO[5] + XO[8]) == x) || ((XO[0] + XO[4] + XO[8]) == x)
					|| ((XO[2] + XO[4] + XO[6]) == x)) {
				return true;
			}
		}
		return false;
	}

	public static void createGrid(int XO[]) {

		for (int i = 0; i < 9; i++) {
			if (XO[i] == 1) {
				System.out.print("[X]");
			} else if (XO[i] == 4) {
				System.out.print("[O]");
			} else {
				System.out.print("[ ]");
			}
			if (i == 2 || i == 5 || i == 8) {
				System.out.println();
			}
		}
	}

	public static int[] resetGame(int XO[]) {
		for (int i = 0; i < 9; i++) {
			XO[i] = 0;
		}
		return XO;
	}

}
