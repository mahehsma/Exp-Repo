import java.util.*;
import java.lang.*;
import java.math.*;
public class SortMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] num = new int[50000]; 			//array of x numbers
		int helpNum = 0;
		int j = 0;
		boolean check = false;
		long tStart = 0;
		long tEnd = 0;
		long tDiff = 0;
		tStart = System.currentTimeMillis();
		System.out.println("Welcome to sort! How many numbers do you want to get sorted?");
		int sortNumbers = in.nextInt();
		System.out.println(sortNumbers);
		for (int i = 0; i < sortNumbers; i++ ) { // Creates as many random numbers as the user wants
			if (sortNumbers < 1) {
				num[0] = 0;
				break;
			}
			else {
				j=0;
				check = false;
				double ranNum = Math.random();
				helpNum = (int)(ranNum * sortNumbers +1);	
				while (check == false) {
					if (num[j] == helpNum) {
						j = 0;
						ranNum = Math.random();
						helpNum = (int)(ranNum * sortNumbers +1);
						}
						else {
							j = j+1;
							if (j > i) {
								num[i] = helpNum;
								check = true;
						}
						
					}
				}
				
			}
//			System.out.print(num[i]+",");
//			if ((i % 15) == 0) {
//				System.out.println();
//			}
		}
		tEnd = System.currentTimeMillis();
		tDiff = (tEnd - tStart);
		System.out.println("it took " + tDiff + "ms to create " + sortNumbers +" numbers");
	}

}
