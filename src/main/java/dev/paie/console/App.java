package dev.paie.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.paie.ihm.Menu;

// 1/ ajouter dépendane Maven (Spring context)
// 2/ creer un contexte Spring
// 3/ cette étape s'effectue dans AppConfig
// 4/ Voir dans Appconfig 
// 5/ Dans le try on creer un objet Menu et on utilise la fonction "démarrer"
// 6/ Dans la classe Menu : on @Autowired un nouvel objet : private ApplicationContext context; et on @Autowired le constructeur "Menu"

public class App 
{
public static void main(String[] args) {
		
	
		// voici le contexte Spring (etape 2) que l'on met dans un try
		// dans le  new AnnotationConfigApplicationContext creer une classe AppConfig. Donc on creer un contexte à partir d'un fichier configuration
		// la prochaine étape c'est completer la classe AppConfig
	
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			
			Menu menu = context.getBean(Menu.class);
			menu.demarrer();
			
		}
	
	
	}
}
