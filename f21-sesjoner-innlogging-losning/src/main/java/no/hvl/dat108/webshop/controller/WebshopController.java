package no.hvl.dat108.webshop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.webshop.model.Cart;
import no.hvl.dat108.webshop.model.CartItem;
import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/webshop")
public class WebshopController {

	@Autowired
	private LoginUtil loginUtil;
	
	/* 
	 * GET /webshop er forespørselen for å vise webshop-siden.
	 */
	@GetMapping
    public String visWebshoppen(HttpSession session, RedirectAttributes ra) {
		
		if (!loginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", "Du må være innlogget ...");
			return "redirect:login";
		}
		return "webshopView";
    }

	/* 
	 * POST /webshop er forespørselen for å handle en/flere varer.
	 */
	@PostMapping
    public String leggVarerIHandlekurv(
    		@RequestParam(name="vare", required=false) List<String> varerAaHandle,
    		HttpSession session, RedirectAttributes ra) {
		
		if (!loginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", "Du må være innlogget ...");
			return "redirect:login";
		}

		/*
		 * Selve katalogen med varer er gjort på en overforenklet måte.
		 * Altså: Vi sier at katalogen inneholder et par varer med navn og pris,
		 * og at varenavnet er unik id for en vare.
		 */
		Map<String, CartItem> katalogvarer = Map.of(
				"bukse", new CartItem("bukse", 789),
				"genser", new CartItem("genser", 456));
		
		//Først sjekke om bruker har krysset av for noen av varene
		if (varerAaHandle != null && !varerAaHandle.isEmpty()) {
			Cart handlekurv = (Cart) session.getAttribute("cart");
			
			//Deretter gå gjennom listen av de som er krysset av
			for (String varenavn : varerAaHandle) {
				
				//Hvis de finnes i katalogen, så legges de i handlekurven.
				if (katalogvarer.containsKey(varenavn)) {
					handlekurv.addItem(katalogvarer.get(varenavn));
				}
			}
		}
		return "redirect:webshop";
    }
}
