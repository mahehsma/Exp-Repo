import java.io.IOException;
import java.util.Scanner;

public class PatientRecordMain {
	static int patientCounter;

	public static void main(String[] args) {
		patientCounter = 0;
		PatientFileIO fileIO = new PatientFileIO();
		PatientRecord pR = new PatientRecord();
		readFile(pR, fileIO);
		for (;;) {
			System.out.println("(1) Show all\n(2) Show patient\n(3) Edit patient\n(4) Add\n(0) Exit");
			Scanner in = new Scanner(System.in);
			int choosenMode = in.nextInt();
			switch (choosenMode) {
			case 1:
				printAll(pR);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				addPatient(pR);
				break;
			case 0:
				safeAll(pR, fileIO);
				break;
			}
		}
	}

	public static void readFile(PatientRecord pR, PatientFileIO fileIO) {
		byte[] storedXML = null;
		try {
			storedXML = fileIO.readFile("PatientRecord");
		} catch (IOException e) {
			System.out.println("No PatientRecord found! Create a new PatientRecord!");
			e.printStackTrace();
		}

		String[] searchFor = { "<patient>", "<name>", "</name>", "<firstName>", "</firstName>", "<gender>", "</gender>",
				"<birthday>", "</birthday>", "</patient>" };
		int x = 0;
		int posFound1 = 0;
		int posFound2 = 0;
		for (x = 0; x < searchFor.length; x++) {
			int j = 0;
			for (int i = 0; i < storedXML.length; i++) {
				if ((char) storedXML[i] == searchFor[x].charAt(j)) {
					j++;
				} else {
					j = 0;
				}
				if (j == searchFor[x].length()) {
					if ((x % 2) == 1) {
						posFound1 = i;
						System.out.println(searchFor[x] + " found at pos: " + posFound1);
					} else {
						posFound2 = i - searchFor[x].length() + 1;
						System.out.println(searchFor[x] + " found at pos: " + posFound2);
					}
					break;
				}
				if (storedXML.length - 1 == i) {
					System.out.println(searchFor[x] + " not found!");
				}
			}
			switch (x) {
			case 0:
				patientCounter++;
				break;
			case 2:
				pR.setLastName(patientCounter - 1, getContent(storedXML, posFound1, posFound2));
				break;
			case 4:
				pR.setFirstName(patientCounter - 1, getContent(storedXML, posFound1, posFound2));
				break;
			case 6:
				pR.setGender(patientCounter - 1, getContent(storedXML, posFound1, posFound2).charAt(0));
				break;
			}
		}

	}

	public static String getContent(byte[] storedXML, int pos1, int pos2) {
		String stringContent = "";
		for (int i = pos1 + 1; i < pos2; i++) {
			stringContent=stringContent+(char)storedXML[i];
		}
		return stringContent;
	}

	public static void printAll(PatientRecord pR) {
		for (int i = 0; i < patientCounter; i++) {
			System.out.println((i + 1) + ":	" + pR.getLastName(i) + "	" + pR.getFirstName(i) + "	" + pR.getGender(i)
					+ "	" + pR.getbirthdate(i));

		}
	}

	public static void addPatient(PatientRecord pR) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please type in first name:");
		String firstName = in.next();
		System.out.println("Please type in last name:");
		String lastName = in.next();
		System.out.println("Please type in gender(m/w/d):");
		char gender = in.next().charAt(0);
		System.out.println("Please type in birthday(DD.MM.YYYY):");
		String birthdate = in.next();
		System.out.println("Is: " + firstName + ", " + lastName + ", " + gender + ", " + birthdate
				+ "\n(1) Correct (save)\n(2) False (edit)");
		if (in.nextInt() == 1) {
			pR.setFirstName(patientCounter, firstName);
			pR.setLastName(patientCounter, lastName);
			pR.setGender(patientCounter, gender);
			pR.setBirthdate(patientCounter, birthdate);
			patientCounter++;

		} else {
			System.out.println("...");
		}

	}

	public static void safeAll(PatientRecord pR, PatientFileIO fileIO) {
		String byteList = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		for (int i = 0; i < patientCounter; i++) {
			byteList = byteList + "<patient> <name> " + pR.getLastName(i) + " </name> <firstName> " + pR.getFirstName(i)
					+ " </firstName> <gender> " + pR.getGender(i) + " </gender> <birthday> " + pR.getbirthdate(i)
					+ " </birthday> </patient> ";
		}
		byte[] patientList = new byte[byteList.length()];
		for (int i = 0; i < byteList.length(); i++) {
			patientList[i] = (byte) byteList.charAt(i);
		}
		fileIO.writeFile("PatientRecord", patientList);
	}

}
