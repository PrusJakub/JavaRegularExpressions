import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Podaj rÛwnanie w formie (plik) (operator) (plik): ");
		System.out.println("u - suma, n - przeciecie, r - roznica");

		Parse parser = new Parse();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String scanner = scan.nextLine();
		Pattern filtrPlik = Pattern.compile("[a-z]+[0-9]");
		Pattern filtrZnak = Pattern.compile(" [a-z]{1}");
		Matcher matcherZnak = filtrZnak.matcher(scanner);
		Matcher matcherPlik = filtrPlik.matcher(scanner);
		String plik1scann = new String();
		String plik2scann = new String();
		String plik1 = new String();
		String plik2 = new String();
		String znak = new String();
		int last = 0;
		matcherPlik.find(last);
		matcherZnak.find();
		plik1scann = matcherPlik.group() + ".txt";
		last = matcherPlik.end();
		znak = matcherZnak.group();
		matcherPlik.find(last);
		plik2scann = matcherPlik.group() + ".txt";

		plik1 = fileReading(plik1scann);
		plik2 = fileReading(plik2scann);

		if (znak.equalsIgnoreCase(" u")) {
			System.out.println("Plik pierwszy: " + plik1);
			System.out.println("Plik drugi: " + plik2);
			System.out.println("Suma: " + parser.suma(plik1, plik2));
		} else if (znak.equalsIgnoreCase(" n")) {
			System.out.println("Plik pierwszy: " + plik1);
			System.out.println("Plik drugi: " + plik2);
			System.out.println("Przeciecie: " + parser.przeciecie(plik1, plik2));
		} else if (znak.equalsIgnoreCase(" r")) {
			System.out.println("Plik pierwszy: " + plik1);
			System.out.println("Plik drugi: " + plik2);
			System.out.println("Roznica: " + parser.roznica(plik1, plik2));
		} else
			System.out.println("èle wprowadzona formu≥a");
	}

	private static String fileReading(String file) throws FileNotFoundException {
		File plik = new File(file);
		@SuppressWarnings("resource")
		Scanner odczyt = new Scanner(plik);
		String tekst = odczyt.nextLine();
		Pattern filtr = Pattern.compile("[0-9]{1,2}:[0-9]{1,2}");
		Matcher matcher = filtr.matcher(tekst);
		String koniec = new String();
		int last = 0;

		while (matcher.find(last)) {
			koniec += " ";
			koniec += matcher.group();
			last = matcher.end();

		}
		while (odczyt.hasNextLine()) {
			last = 0;
			tekst = odczyt.nextLine();
			matcher = filtr.matcher(tekst);
			while (matcher.find(last)) {
				koniec += " ";
				koniec += matcher.group();
				last = matcher.end();

			}
		}
		return koniec;
	}
}
