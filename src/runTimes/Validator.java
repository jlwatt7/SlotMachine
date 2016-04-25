package runTimes;
import java.util.*;

public class Validator { // Bill's Validator class blatantly stolen for my
							// benefit
	static Scanner scan = new Scanner(System.in);

	public static int readValidInt() {
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.print("Please enter a number: ");
		}
		int x = scan.nextInt();
		scan.nextLine();
		return x;
	}

	public static int getValidInt(int min, int max) {
		int i = readValidInt();
		while (i < min || i > max) {
			System.out.print("Please enter a number within range! (" + min + "-" + max + "): ");
			i = readValidInt();
		}
		return i;
	}

	public static String readYorN(String x, String y) {
		String z = scan.nextLine();
		while (!(z.equalsIgnoreCase(x) || z.equalsIgnoreCase(y))) {
			System.out.print("Invalid option, use 'y' or 'n': ");
			z = scan.nextLine();
		}
		return z;
	}

	public static String readValidString(int l) {
		while (!scan.hasNextLine() && scan.nextLine().length() > l) {
			scan.nextLine();
			System.out.print("Please enter a valid option: ");
		}
		String x = scan.nextLine();
		return x;
	}

	public static String getValidString(String inputs, int length) {
		String i = readValidString(length);
		while (!(i.matches(inputs))) {
			System.out.print("Please only input the name with letters: ");
			i = readValidString(length);
		}
		return i;
	}

	public static int getValidBet(int min, int max) {
		int i = readValidInt();
		while (i > 5 || i < min) {
			if (i > max) {
				System.out.print("Don't try betting money you don't have, fool! (you have " + max + " dollars left): ");
			i = readValidInt();
			} else { 
				System.out.print("Please enter a valid bet (" + min + "-" + max +")");
			i = readValidInt();
			}
		}
		return i;
	}
}