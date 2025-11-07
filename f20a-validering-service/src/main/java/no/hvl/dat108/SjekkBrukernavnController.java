package no.hvl.dat108;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SjekkBrukernavnController {
	
	/* Denne blir auto-wired via feltet direkte (magi).
	 * Spring vil da lage et objekt av typen InputValidator og
	 * putte (injisere) dette inn i controlleren. */
	@Autowired
	private InputValidator inputValidator;

	@GetMapping("/skjema")
	public String brukenavnSkjema() {
		return "skjema";
	}

	@GetMapping("/sjekkBrukernavn")
	public String sjekkBrukernavn(Model model, String brukernavn) {

		boolean gyldig = inputValidator.erGyldigBrukernavn(brukernavn);
		
		if (!gyldig) {
			model.addAttribute("feilmelding", 
					"Brukernavnet må være 3 eller flere tegn, og ikke allerede i bruk.");
			return "skjema"; 
		}
		//Kommer vi hit, er alt i orden
		return "tilbakemelding";
	}
	
}
