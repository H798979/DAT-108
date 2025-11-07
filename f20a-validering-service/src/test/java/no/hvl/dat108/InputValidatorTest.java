package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * "Et gyldig brukernavn er 3 eller flere tegn, og ikke allerede i bruk."
 */
public class InputValidatorTest {
	
	/* Ved testing er det vanlig å bruke en "fake" database uansett ! */
	private DatabaseHelper databaseHelper = new MyDatabaseHelper();
    private InputValidator inputValidator = new InputValidator(databaseHelper);
    
	@Test
	void nullErUgyldigBrukernavn() {
		assertFalse(inputValidator.erGyldigBrukernavn(null));
	}
	
	@Test
	void korteNavnErUgyldigeBrukernavn() {
		assertFalse(inputValidator.erGyldigBrukernavn(""));
		assertFalse(inputValidator.erGyldigBrukernavn("x"));
		assertFalse(inputValidator.erGyldigBrukernavn("xx"));
		assertFalse(inputValidator.erGyldigBrukernavn("xx "));
		assertFalse(inputValidator.erGyldigBrukernavn(" xx"));
	}

	@Test
	void noenGyldigeBrukernavn() {	
		assertTrue(inputValidator.erGyldigBrukernavn("arne"));
		assertTrue(inputValidator.erGyldigBrukernavn("nils"));
		assertTrue(inputValidator.erGyldigBrukernavn("tone"));
		assertTrue(inputValidator.erGyldigBrukernavn("åse"));
	}
	
    @Test
    void ikkeLedigeBrukernavn() {
		assertFalse(inputValidator.erGyldigBrukernavn("per"));
		assertFalse(inputValidator.erGyldigBrukernavn("espen"));
    }
}
