package no.hvl.lph.dat108.solution;

import java.io.IOException;

import no.hvl.lph.dat108.Fiat;
import no.hvl.lph.dat108.Krypto;

public class PrisfinnerSomKasterUnntak implements Prisfinner {

	@Override
	public double finnPris(String kryptoCode, String fiatCode) throws IOException {
		
		if (!Krypto.ETH.name().equals(kryptoCode) 
				|| !Fiat.USD.name().equals(fiatCode)) {
			throw new IllegalArgumentException();
		}
		throw new IOException();
	}

}
