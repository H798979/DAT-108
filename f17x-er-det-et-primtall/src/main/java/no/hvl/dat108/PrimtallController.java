package no.hvl.dat108;

import org.apache.commons.math3.primes.Primes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrimtallController {
	
	@GetMapping("/primtall")
	public String mottaRegistrering(Model model, 
			@RequestParam int tallet) {
		
		//Validering av brukerinput!
		
		//Sjekk om primtall
		String melding;
		if (Primes.isPrime(tallet)) {
			melding = " er et primtall!";
		} else {
			melding = " er IKKE et primtall!";
		}
		
		model.addAttribute("melding", melding);
		return "primsvar";
	}
	
	
}
