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
				float[] pcSet=new float[9];
				pcSet = pcChoose(XO, pcOrPlayer);
				int set=0;
				for (int j=0;j<8;j++) {
					System.out.println(pcSet[j]);
					if (pcSet[j]<pcSet[j+1]) {
						set=j+1;
					}
				}
				XO[set] = 1;
				System.out.println(set);
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
				i=8;
				break;
			}
		}
		for (int j=0; j<9;j++) {
			System.out.print(XO[j]);
		}
	}

	public static float[] pcChoose(int xOrO[], boolean pcOrPlayer) {
		float XOminimax[] = new float[9];
		float thisField[]=new float[9];

		for (int i = 0; i < 9; i++) {
			if (xOrO[i] == 0) {//i=0?
				if (i != 0) {
					xOrO[i - 1] = 0;
				}
				if (pcOrPlayer == true) {
					xOrO[i] = 1;
					pcOrPlayer = false;
				} else {
					xOrO[i] = 4;
					pcOrPlayer = true;
				}
				if (hasWon(xOrO) == true) {
					if (pcOrPlayer == true) {
						XOminimax[i]=0;
					} else {
						XOminimax[i]=3;
					}
				} else if (hasWon(xOrO)==false &&i==8){
					XOminimax[i]=1;
				} else{
					thisField=pcChoose(xOrO, pcOrPlayer);
					float help=thisField[1];
					for (int j=1;j<9;j++) {
						if(help<thisField[j]) {
							help=thisField[j];
						}
					}
					XOminimax[i]=help/2;
				}

			}
		}
		return XOminimax;
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
