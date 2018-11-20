package dev.paie.ihm;

public abstract class OptionMenu {
	
	protected String libelle;
	
	public OptionMenu(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	
	public String getLibelle() {
		return libelle;
	}


// abstract car elle va etre redéfinit dans toutes les classes filles
	abstract public void executer();

}
