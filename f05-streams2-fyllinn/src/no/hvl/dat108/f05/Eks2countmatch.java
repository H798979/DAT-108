package no.hvl.dat108.f05;

import static no.hvl.dat108.f05.People.people;

public class Eks2countmatch {

	public static void main(String[] args) {

		//Alle forbokstavene i fornavnene i en streng "CLTCM" - reduce() 
		String forbokstaver = people.stream()
			.map(p -> p.firstName())
			.map(navn -> navn.substring(0, 1))
			.reduce("", (acc, b) -> acc + b);
		System.out.println(forbokstaver);
		
		//Antall personer over 50 år - count()
		long antallOver50 = people.stream()
			.filter(p -> p.age() > 50)
			.count();
		System.out.println(antallOver50);

		
		//Om vi har data som matcher - anyMatch(), allMatch(), noneMatch()
		//Er alle over 30 år?
		//Er noen over 60 år?
		boolean  noenOver30 = people.stream(allMatch(p -> p.age() > 30));
		boolean  noenOver60 = people.stream(anyMatch(p -> p.age() > 60));


	}

}




