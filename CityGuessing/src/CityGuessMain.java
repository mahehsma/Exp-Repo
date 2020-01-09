import java.util.Scanner;

public class CityGuessMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CityStack europe = new CityStack(15);
		europe.setCapitalCountry("Berlin", "Germany", 82000000);
		europe.setCapitalCountry("Paris", "France", 67000000);
		europe.setCapitalCountry("Rome", "Italy", 60500000);
		europe.setCapitalCountry("Helsinki", "Finland", 5500000);
		europe.setCapitalCountry("Lisbon", "Portugal", 10300000);
		europe.setCapitalCountry("Oslo", "Norway", 5330000);
		europe.setCapitalCountry("Madrid", "Spain", 46660000);
		europe.setCapitalCountry("Athens", "Greece", 10740000);
		europe.setCapitalCountry("Budapest", "Hungary", 9773000);
		europe.setCapitalCountry("Reykjavik", "Iceland", 363000);
		europe.setCapitalCountry("Ankara", "Turkey", 80810000);
		europe.setCapitalCountry("Luxembourg", "Luxembourg", 602000);
		System.out.println("Want to guess or add cities?\n (1) Guess\n (2) Edit");
		int choosenMode = 0;
		do {
			try {
				choosenMode = in.nextInt();
			} catch (Exception e) {
				System.out.println("Wrong input! Try again!");
				choosenMode = 0;

			}
		} while (choosenMode != 1 && choosenMode != 2);
		System.out.println(choosenMode);

		if (choosenMode == 1) {
			boolean repeatGuessing = true;
			System.out.println("Type 'end' to stop guessing");
			do {
				int selectedCombination = (int) (Math.random() * (europe.getItemCounter() - 1));
				int countryOrCapitalOrPopulation = (int) (Math.random() * 3);
				if (countryOrCapitalOrPopulation == 0) {
					System.out.println("The capital of " + europe.getCountry(selectedCombination) + " is:");
					String guessedCapital = in.next();
					if (guessedCapital.equals("end")) {
						repeatGuessing = false;
						break;
					} else if (guessedCapital.equals(europe.getCapital(selectedCombination))) {
						System.out.println("That's correct!");
					} else {
						System.out.println("No, it's not " + guessedCapital + ", it is "
								+ europe.getCapital(selectedCombination) + "!");
					}
				} else if (countryOrCapitalOrPopulation == 1) {
					System.out.println(europe.getCapital(selectedCombination) + " is the capital of:");
					String guessedCountry = in.next();
					if (guessedCountry.contentEquals("end")) {
						repeatGuessing = false;
						break;
					}
					if (guessedCountry.equals(europe.getCountry(selectedCombination))) {
						System.out.println("That's correct!");
					} else {
						System.out.println("No, it's not " + guessedCountry + ", it is "
								+ europe.getCountry(selectedCombination) + "!");
					}
				} else {
					System.out.println("The population of " + europe.getCountry(selectedCombination) + " is:");
					float guessedPopulation = in.nextInt();
					float pop = europe.getPopulation(selectedCombination);
//					System.out.println(guessedPopulation);
					if (guessedPopulation >= (pop - pop / 50) && guessedPopulation <= (pop + pop / 50)) {
						System.out.println(
								"Wow! Very good! Right answer is: " + europe.getPopulation(selectedCombination) + ".");
					} else if (guessedPopulation >= (pop - pop / 10) && guessedPopulation <= (pop + pop / 10)) {
						System.out.println("Good! Right answer is: " + europe.getPopulation(selectedCombination) + ".");
					} else if (guessedPopulation >= (pop - pop / 4) && guessedPopulation <= (pop + pop / 4)) {
						System.out.println(
								"Hm okay.. Right answer is: " + europe.getPopulation(selectedCombination) + ".");
					} else {
						System.out
								.println("Wrong! Right answer is: " + europe.getPopulation(selectedCombination) + ".");
					}
				}
			} while (repeatGuessing);
		}
		if (choosenMode == 2) {
			int chooseEdit;
			do {
				System.out.println("(1) Show all\n(2) Add\n(3) Delete\n(4) Back");
				chooseEdit = in.nextInt();
			} while (chooseEdit != 1 && chooseEdit != 2 && chooseEdit != 3 && chooseEdit != 4);
			switch (chooseEdit) {
			case 1:
				for (int i = 0; i < europe.itemCounter; i++) {
					System.out.println(i+"	" + europe.getCountry(i)+"    " + "	" + europe.getCapital(i)+"    " + "	Population: "
							+ europe.getPopulation(i));
				}
				break;
			case 2:
				boolean repeatAdding = true;
				do {
					System.out.println("Type 'end' to stop adding items.");
					System.out.println("Capital:");
					String input = in.next();
					if (input.contentEquals("end")) {
						repeatAdding = false;
						break;
					}
					String cap = input;
					System.out.println("Country:");
					input = in.next();
					if (input.contentEquals("end")) {
						repeatAdding = false;
						break;
					}
					String cou = input;
					europe.setCapitalCountry(cap, cou, 0);
					System.out.println(cap + ", " + cou + " has been added!");
				} while (repeatAdding);
				break;
			}
		}
	}

}
