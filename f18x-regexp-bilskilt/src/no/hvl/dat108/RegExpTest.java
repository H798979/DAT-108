package no.hvl.dat108;
/*
 * https://en.wikipedia.org/wiki/Regular_expression
 * 
 * "A regular expression (shortened as regex or regexp; sometimes 
 * referred to as rational expression) is a sequence of characters 
 * that specifies a search pattern in text. Usually such patterns are 
 * used by string-searching algorithms for "find" or "find and replace" 
 * operations on strings, or for input validation."
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegExpTest {

	/* Noen eksempler på regulære uttrykk */
	String START 				= "^";
	String SLUTT 				= "$";
	String x_NULL_ELLER_FLERE 	= "*";
	String x_EN_ELLER_FLERE 	= "+";
	String x_NULL_ELLER_EN 		= "?";
	String x_TO 				= "{2}";
	String x_FEM 				= "{5}";
	String x_ÅTTE 				= "{8}";
	String x_TRE_ELLER_FLERE 	= "{3,}";
	String x_TRE_TIL_SEKS 		= "{3,6}";
	String x_TO_TIL_NITTEN 		= "{2,19}";
	String STOR_BOKSTAV_AZ 		= "[A-Z]";
	String STOR_BOKSTAV_AÅ 		= "[A-ZÆØÅ]";
	String BOKSTAV_AZ 			= "[A-Za-z]";
	String BOKSTAV_AÅ 			= "[A-Za-zÆØÅæøå]";
	String SIFFER 				= "\\d";
	
	String eksakt(String regexp) {
		return START + regexp + SLUTT;
	}
	
	@Test
	void mobil() {
		
		/* Vi vil at et mobilnummer er eksakt 8 siffer */
		String mobilRegexp = eksakt(SIFFER + x_ÅTTE);
		System.out.println("mobilRegexp:" + mobilRegexp);

		String mobil1 = "12345678";
		String mobil2 = "1234567A";
		String mobil3 = "123456789";
		
		assertTrue(mobil1.matches(mobilRegexp));
		assertFalse(mobil2.matches(mobilRegexp));
		assertFalse(mobil3.matches(mobilRegexp));
	}
	
	@Test
	void bilnr() {
		
		/* Vi vil at et bilnummer er eksakt 2 store bokstaver (AZ) + 5 siffer */
		String bilnrRegexp = eksakt(STOR_BOKSTAV_AZ + x_TO + SIFFER + x_FEM);
		System.out.println("bilnrRegexp:" + bilnrRegexp);

		String bilnr1 = "SU12345";
		String bilnr2 = "SØ12345";
		String bilnr3 = "SV123456";
		
		assertTrue(bilnr1.matches(bilnrRegexp));
		assertFalse(bilnr2.matches(bilnrRegexp));
		assertFalse(bilnr3.matches(bilnrRegexp));
	}
	
	@Test
	void navn() {
		
		/* Vi vil at et navn er 3 til 20 bokstaver, og den første må være STOR.
		 * Dvs. vi kan også ha mellomrom og bindestrek, men ikke først eller sist.
		 */
		String navnRegexp = eksakt(STOR_BOKSTAV_AÅ + BOKSTAV_AÅ + x_TO_TIL_NITTEN);
		System.out.println("navnRegexp :" + navnRegexp);

		String navn1 = "Pål";
		String navn2 = "PålPålPålPålPålPålPål"; //21 tegn
		String navn3 = "På";  //2 tegn
		String navn4 = "pål"; //Starter med liten bokstav
		
		assertTrue(navn1.matches(navnRegexp));
		assertFalse(navn2.matches(navnRegexp));
		assertFalse(navn3.matches(navnRegexp));
		assertFalse(navn4.matches(navnRegexp));
	}
	
	@Test
	void elbil() {
		
		/* Vi vil at et bilnummer til elbil starter med en av
		 * EL EK EV EB EC ED EE EF EH 
		 * */
		String elbilRegexp = eksakt("E[LKVBCDEFH]" + SIFFER + x_FEM);
		System.out.println("elbilRegexp:" + elbilRegexp);

		String bilnr1 = "EE12345";
		String bilnr2 = "EX12345";
		String bilnr3 = "SU123456";
		
		assertTrue(bilnr1.matches(elbilRegexp));
		assertFalse(bilnr2.matches(elbilRegexp));
		assertFalse(bilnr3.matches(elbilRegexp));
	}

}
