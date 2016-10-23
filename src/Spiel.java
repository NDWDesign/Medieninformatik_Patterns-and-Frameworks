import java.util.InputMismatchException;
import java.util.Scanner;

public class Spiel {
	/**
	 * Hauptroutine von Spiel
	 */
	public static void main(String[] args) {

		int maxNumber = 10,
				input,
				number;

		number = (int) Math.round(Math.random() * maxNumber);

		System.out.println("Gesucht wird eine Zahl zwischen 0 und " + maxNumber);

		while ((input = getIntegerFromInput()) != number) {
			if (input < number) {
				System.out.println("Zu erratende Zahl ist größer als " + input);
			}
			else if (input > number) {
				System.out.println("Zu erratende Zahl ist kleiner als " + input);
			}
		}

		System.out.println("Herzlichen Glückwunsch! Die zu erratende Zahl ist " + number);
	}

	/**
	 * Liefert einen Integer von der Eingabeaufforderung
	 *
	 * @return int
	 */
	private static int getIntegerFromInput() {

		int input;

		System.out.println("Zahl eingegeben: ");

		try {
			input = new Scanner(System.in).nextInt();
		} catch (InputMismatchException $e) {
			System.out.println("Ihre Eingabe war keine gültige Zahl. Bitte versuchen sie es erneut");
			return getIntegerFromInput();
		}
		return input;
	}
}