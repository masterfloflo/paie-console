package dev.paie.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;
@Controller
public class Menu {
	
	// Mapping d'un integer avec un élément du Menu. Pour que quand le tableau s'affiche l'utilisateur renseigne sa requete avec le chiffre qui correspond.
	private Map<Integer, OptionMenu> options = new HashMap<>();
	
	private Scanner scanner;
	
	private ApplicationContext context;
	
	public Menu(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		init(scanner, cotisService, context);
		this.scanner = scanner;
	}

	private void init(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		
		// recherche dans le contexte des beans Spring de type OptionMenu
		Map<String, OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class);
		// creation d'un incrément remplace le i++ a cause de la lambda
		//AtomicInteger permet de gerer des incréments dans un contexte concurrent 
		AtomicInteger increment = new AtomicInteger();
		beansTrouves.forEach((idSpring, valeur) -> {
			this.options.put(increment.incrementAndGet(), valeur);
		});
	}
	
	/* Possibilité 2 sans l'atomic integer et avec une boucle for
	 * 
	 * 
	 * private void init(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		
		Map<String, OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class);

		Collection <OptionMenu> optionsTrouve = beansTrouves.values();
		
		int i = 1;
		for (OptionMenu opt : optionsTrouve) {
		tis.options.put(i, opt);
		i++; } }
		
		
		this.options.put(1, new ListerCotisationsOptionMenu(cotisService));
		this.options.put(2, new CreerCotisationOptionMenu(scanner));
		this.options.put(3, new SupprimerCotisationOptionMenu(scanner, cotisService));
	 * 
	 * 
	 * */
	
	public void demarrer() {
		
		// Afficher les libellés des options
		while(true) {
			this.options.forEach((key, option) -> {
				System.out.println(key + ". " + option.getLibelle());
			});

			int optionMenuChoisie = this.scanner.nextInt();
			
			this.options.get(optionMenuChoisie).executer();
			
					}
		}
		}
