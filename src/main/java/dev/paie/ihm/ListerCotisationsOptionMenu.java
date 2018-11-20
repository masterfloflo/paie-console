package dev.paie.ihm;

import dev.paie.service.CotisationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class ListerCotisationsOptionMenu extends OptionMenu {

	@Autowired private CotisationService cotisService;

	public ListerCotisationsOptionMenu(CotisationService cotisService) {
		super("Lister les cotisations");
		this.cotisService = cotisService;
	}

	@Override
	public void executer() {
		System.out.println("Listage en cours");
		this.cotisService.lister().forEach(cotis -> System.out.println(cotis.toString()));
		
	}

}
