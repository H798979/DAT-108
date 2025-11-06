package no.hvl.lph.dat108.solution;

import java.io.IOException;

import no.hvl.lph.dat108.Fiat;
import no.hvl.lph.dat108.Krypto;

public class PrisfinnerMedHardkodetPris implements Prisfinner {

	/* 
	 * Forventer et kall for å finne ETH-kurs i USD.
	 * I så fall: Returnerer en fast kryptokurs på 3000.03 USD/ETH.
	 */
	@Override
	public double finnPris(String kryptoCode, String fiatCode) throws IOException {
		
		if (!Krypto.ETH.name().equals(kryptoCode) 
				|| !Fiat.USD.name().equals(fiatCode)) {
			throw new IllegalArgumentException();
		}
		return 3000.03d;
	}
}