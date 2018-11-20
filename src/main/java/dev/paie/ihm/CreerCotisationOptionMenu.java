package dev.paie.ihm;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.domain.Cotisation;
import dev.paie.service.CotisationService;
@Controller
public class CreerCotisationOptionMenu extends OptionMenu {

	@Autowired private Scanner scanner;
	@Autowired private CotisationService cotcot;
	
	public CreerCotisationOptionMenu(Scanner scanner) {
		super("Créer une cotisation");
		this.scanner = scanner;
	}

	@Override
	public void executer() {
		System.out.println("Création en cours");
		
		System.out.println("Veuillez saisir le code de la cotisation: ");
		String codeSaisie = this.scanner.next();
		
		System.out.println("Veuillez saisir le libelle de la cotisation: ");
		String libelle = this.scanner.next();		
		
		System.out.println("Veuillez saisir si l'utilisateur est imposable de la cotisation: ");
		Boolean imposable = this.scanner.nextBoolean();	
		
		System.out.println("Veuillez saisir le tauxPatronal de la cotisation: ");
		BigDecimal tauxPatronal = this.scanner.nextBigDecimal();	
		
		System.out.println("Veuillez saisir le tauxSalarial de la cotisation: ");
		BigDecimal tauxSalarial = this.scanner.nextBigDecimal();	
		
		cotcot.sauver(codeSaisie, libelle, imposable, tauxPatronal, tauxSalarial);
		
		
	
	}

}
