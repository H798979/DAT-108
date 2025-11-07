package no.hvl.dat108;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputValidator {
	
	/* Denne blir auto-wired via konstruktøren.
	 * Spring vil da lage et objekt av typen MyDatabaseHelper og
	 * putte (injisere) dette inn i validatoren.
	 * 
	 * NB! Vi kunne ikke gjort dette hvis ikke InputValidator selv
	 * var en komponent, f.eks. en @Controller eller en @Service.
	 */
	DatabaseHelper databaseHelper;

	@Autowired
	public InputValidator(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	/*
	 * Valideringsmetoden.
	 * "Et gyldig brukernavn er 3 eller flere tegn, og ikke allerede i bruk."
	 */
	public boolean erGyldigBrukernavn(String brukernavn) {
		
		//Steg1: Ikke godta null
		if (brukernavn == null) {
			return false;
		}
		
		//Steg2: Sjekke om 3 eller flere tegn
		if (brukernavn.trim().length() < 3) {
			return false;
		}
		
		//Steg3: Sjekke om brukernavn allerede er i bruk
		return databaseHelper.erBrukernavnLedig(brukernavn);
	}
}




