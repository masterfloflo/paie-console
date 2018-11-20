package dev.paie.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;
@Controller
public class SupprimerCotisationOptionMenu extends OptionMenu {

	@Autowired private CotisationService cotisSup;
	
	@Autowired private Scanner scanner;

	
	public SupprimerCotisationOptionMenu() {
		super("Supprimer une cotisation");
		
	}
	
	@Override
	public void executer() {
		System.out.println("Suppression en cours");
		
		System.out.println("Veuillez saisir le code : ");

		String codeSaisie = this.scanner.next();
		cotisSup.supprimer(codeSaisie);
		System.out.println("Vous avez supprimer :" + codeSaisie);
	}
	
	
}
