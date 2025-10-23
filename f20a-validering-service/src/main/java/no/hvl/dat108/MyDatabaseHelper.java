package no.hvl.dat108;

import java.util.List;

import org.springframework.stereotype.Service;

/*
 * En fake implementasjon for demonstrasjon i timen. 
 */
@Service
public class MyDatabaseHelper implements DatabaseHelper {
	
	List<String> opptatteBrukernavn = List.of("per", "paal", "espen"); 

	@Override
	public boolean erBrukernavnLedig(String brukernavn) {
		return !opptatteBrukernavn.contains(brukernavn);
	}
}
