package no.hvl.dat108;

/* 
 * Felles interface for databasetilgang. Ulike databaser
 * kan ha ulike implementeringer av dette.
 */
public interface DatabaseHelper {
	boolean erBrukernavnLedig(String brukernavn);
}
