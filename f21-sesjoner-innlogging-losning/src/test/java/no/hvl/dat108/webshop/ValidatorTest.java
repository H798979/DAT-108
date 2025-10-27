package no.hvl.dat108.webshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.hvl.dat108.webshop.util.InputValidator;

public class ValidatorTest {

	private InputValidator inputValidator = new InputValidator();
	
    /*
     * Et gyldig brukernavn består av 4 eller flere tegn. Lovlige tegn
     * er bokstaver (små og store) inkl. de norske bokstavene, og tall.
     * Brukernavnet kan ikke begynne med et tall.
     */
	
    @Test
    public void validUsernamesShouldBeOk() {
        assertTrue(inputValidator.isValidUsername("aaaa"));
        assertTrue(inputValidator.isValidUsername("aAaA"));
        assertTrue(inputValidator.isValidUsername("abc4"));
        assertTrue(inputValidator.isValidUsername("A6789b"));
        assertTrue(inputValidator.isValidUsername("A6789b"));
    }
    
    @Test
    public void norwegianLettersShouldBeAllowed() {
        assertTrue(inputValidator.isValidUsername("æøåÆØÅ"));
    }
    
    @Test
    public void shortUsernamesShouldNotBeOk() {
        assertFalse(inputValidator.isValidUsername(null));
        assertFalse(inputValidator.isValidUsername(""));
        assertFalse(inputValidator.isValidUsername("a"));
        assertFalse(inputValidator.isValidUsername("ABC"));
    }
    
    @Test
    public void usernamesWithIllegalCharsShouldNotBeOk() {
        assertFalse(inputValidator.isValidUsername("a-bcd"));
        assertFalse(inputValidator.isValidUsername("a@bcd"));
    }
    
    @Test
    public void usernamesStartingWithANumberShouldNotBeOk() {
        assertFalse(inputValidator.isValidUsername("1abcde"));
        assertFalse(inputValidator.isValidUsername("0ABCDE"));
    }
    
    

}
