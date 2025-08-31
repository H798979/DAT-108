package no.hvl.dat108.f04;

import static no.hvl.dat108.f05.People.people;

import java.util.stream.Stream;

import no.hvl.dat108.f05.Person;

/*
 * Eksempel8
 *
 * Fikk spørsmål i forrige time f04 om gjenbruk av Stream-objekter.
 * 
 * Vi ser litt på det i dette eksemplet, med utgangspunkt i listen
 * av Person-objekter, people.
 */
public class Eksempelx {

	public static void main(String[] args) {
		
		Stream<Person> streamAvPersoner = people.stream();
		
//		streamAvPersoner.forEach(System.out::println); // OK. forEach() er terminal. Lukker strømmen.
//		streamAvPersoner.forEach(System.out::println); // Får IllegalStateException: Closed.
		
//		streamAvPersoner.filter(p->p.age()>50);
//		streamAvPersoner.forEach(System.out::println); // Får IllegalStateException: Operated on.
		
		streamAvPersoner = streamAvPersoner.filter(p->p.age()>50);
		streamAvPersoner.forEach(System.out::println); // OK.

		
		
	}
		
}














