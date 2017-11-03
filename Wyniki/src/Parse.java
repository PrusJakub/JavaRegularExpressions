import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
	public String suma(String plik1, String plik2) {
		int i;
		int j;
		String[] tablica = makeBoard2(plik1, plik2);

		for (i = 0; i < 99; i++) {
			for (j = i + 1; j < 100; j++) {
				String a = tablica[i];
				String b = tablica[j];
				if (a == null)
					i++;
				else if (a.equalsIgnoreCase(b))
					tablica[j] = null;
			}
		}
		String ret = new String();
		for (j = 0; j < 100; j++) {
			if (tablica[j] != null)
				ret += tablica[j] + " ";
		}
		return ret;
	}

	public String roznica(String plik1, String plik2) {
		String[] tablica1 = makeBoard1(plik1);
		String[] tablica2 = makeBoard1(plik2);
		String[] tablica = new String[100];
		boolean flaga = false;
		for (int i = 0; i < tablica1.length; i++) {
			if (tablica1[i] == null) {
			} else {
				for (int j = 0; j < tablica2.length; j++)
					if (tablica1[i].equalsIgnoreCase(tablica2[j]))
						flaga = true;
				if(flaga == false)
					tablica[i] = tablica1[i];
			}
			flaga = false;
		}
		String ret = new String();
		for (int j = 0; j < 100; j++) {
			if (tablica[j] != null)
				ret += tablica[j] + " ";
		}
		return ret;

	}

	public String przeciecie(String plik1, String plik2) {
		String[] tablica1 = makeBoard1(plik1);
		String[] tablica2 = makeBoard1(plik2);
		String[] tablica = new String[100];
		
		boolean flaga = false;
		for (int i = 0; i < tablica1.length; i++) {
			if (tablica1[i] == null) {
			} else {
				for (int j = 0; j < tablica2.length; j++)
					if (tablica1[i].equalsIgnoreCase(tablica2[j]))
						flaga = true;
				if(flaga)
					tablica[i] = tablica1[i];
			}
			flaga = false;
		}
		String ret = new String();
		for (int j = 0; j < 100; j++) {
			if (tablica[j] != null)
				ret += tablica[j] + " ";
		}
		return ret;

		
		
	}
	private String[] makeBoard2(String plik1, String plik2) {
		String[] tablica = new String[100];
		Pattern filtr = Pattern.compile("[0-9]{1,2}:[0-9]{1,2}");
		Matcher matcher1 = filtr.matcher(plik1);
		Matcher matcher2 = filtr.matcher(plik2);
		int i = 0;
		int j = 0;
		while (matcher1.find(i)) {
			tablica[j] = matcher1.group();
			i = matcher1.end();
			j++;
		}

		i = 0;

		while (matcher2.find(i)) {
			tablica[j] = matcher2.group();
			i = matcher2.end();
			j++;
		}
		return tablica;
	}

	private String[] makeBoard1(String plik1) {
		String[] tablica = new String[100];
		Pattern filtr = Pattern.compile("[0-9]{1,2}:[0-9]{1,2}");
		Matcher matcher1 = filtr.matcher(plik1);
		int i = 0;
		int j = 0;
		while (matcher1.find(i)) {
			tablica[j] = matcher1.group();
			i = matcher1.end();
			j++;
		}

		return tablica;
	}
}
