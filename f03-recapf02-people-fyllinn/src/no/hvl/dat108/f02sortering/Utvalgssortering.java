package no.hvl.dat108.f02sortering;

import java.util.List;

public class Utvalgssortering {
	
	/*
	 * For å fremdeles ha muligheten til å sortere på a.compareTo(b) uten å gi
	 * inn en ekstra paramterer, så beholder vi den "gamle" metoden.
	 */
	public static <T extends Comparable<? super T>> void sorter(List<T> liste) {
		int n = liste.size(); // antall elementer i listen
		
		for (int i = 0; i < n; i++) {
			T min = liste.get(i);
			int minIndeks = i;

			for (int j = i + 1; j < n; j++) {
				T aktuell = liste.get(j);
				
				if (aktuell.compareTo(min) < 0) {
					min = aktuell;
					minIndeks = j;
				}
			}

			// swap ↄ: bytt liste[i] med min (funnet over)
			T temp = liste.get(i);
			liste.set(i, min);
			liste.set(minIndeks, temp);
		}
	}
	
	/*
	 * Her har vi utvidet sorter med en ekstra Sammenligner-parameter som brukes
	 * i stedet for a.compareTo(b).
	 * 
	 * Kan da sortere på ulike måter bestemt av logikken i Sammenligner-objektet,
	 * og får en mye mer fleksibel og anvendelig sorteringsmetede.
	 */
	public static <T> void sorter(List<T> liste, Sammenligner<T> sammenligner) {
		
		int n = liste.size(); // antall elementer i listen
		
		for (int i = 0; i < n; i++) {
			T min = liste.get(i);
			int minIndeks = i;

			for (int j = i + 1; j < n; j++) {
				T aktuell = liste.get(j);
				
/* Før:			if (aktuell.compareTo(min) < 0) {			*/
/* Nå: */		if (sammenligner.sammenlign(aktuell, min) < 0) {
					min = aktuell;
					minIndeks = j;
				}
			}

			// swap ↄ: bytt liste[i] med min (funnet over)
			T temp = liste.get(i);
			liste.set(i, min);
			liste.set(minIndeks, temp);
		}
	}
}
