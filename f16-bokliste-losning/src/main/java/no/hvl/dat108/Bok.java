package no.hvl.dat108;

public record Bok(String tittel, String forfatter, int utgivelsesaar) {
	
	/* Siden EL-uttrykk som ${bok.tittel} ihht. JavaBean-spesifikasjonen 
	 * tolkes som et kall til bok.getTittel(), og record i stedet har kalt 
	 * denne metoden for bok.tittel(), vil det ikke virke uten videre
	 * med records. En enkel fiks kan være å legge til aktuelle gettere:
	 */
	public String getTittel() { return tittel(); }
	public String getForfatter() { return forfatter(); }
	public int getUtgivelsesaar() { return utgivelsesaar(); }

	/* Vi har likevel fordeler med record siden vi får gratis:
	 * - instansvariabler
	 * - parametrisk konstruktør
	 * - ikke-muterbare instanser
	 * - equals og hashcode
	 * - toString
	 */
}
