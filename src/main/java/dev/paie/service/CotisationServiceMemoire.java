package dev.paie.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.domain.Cotisation;


public class CotisationServiceMemoire implements CotisationService {

	private List<Cotisation> cotisations = new ArrayList<>();

	@Override
	public List<Cotisation> lister() {
		return cotisations;

	}

	@Override
	public Cotisation sauver(String code, String libelle, Boolean imposable, BigDecimal tauxPatronal,
			BigDecimal tauxSalarial) {
		
		//création d'une nouvelle cotisation avec les paramètres d'entrée de la méthode sauver
		Cotisation cotis = new Cotisation();
		
		cotis.setCode(code);
		cotis.setLibelle(libelle);
		cotis.setTauxPatronal(tauxPatronal);
		cotis.setTauxSalarial(tauxSalarial);
		cotis.setImposable(imposable);
		
		cotisations.add(cotis);
		return cotis;

	}

	@Override
	public void supprimer(String code) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
