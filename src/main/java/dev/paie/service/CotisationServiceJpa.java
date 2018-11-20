package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.domain.Cotisation;
import dev.paie.repository.CotisationRepository;

@Service
public class CotisationServiceJpa implements CotisationService {

	@Autowired
	private CotisationRepository cotisRepo;

	@Override
	public List<Cotisation> lister() {
		return cotisRepo.findAll();
	}

	@Override
	public Cotisation sauver(String codeSaisie, String libelle, Boolean imposable, BigDecimal tauxPatronal,
			BigDecimal tauxSalarial) {
		Cotisation cotis = new Cotisation();

		cotis.setCode(codeSaisie);
		cotis.setLibelle(libelle);
		cotis.setTauxPatronal(tauxPatronal);
		cotis.setTauxSalarial(tauxSalarial);
		cotis.setImposable(imposable);

		return cotisRepo.save(cotis);
	}

	@Override
	public void supprimer(String codeSaisie) {
		for (Cotisation cotis : cotisRepo.findByCode(codeSaisie))
		{
			cotisRepo.delete(cotis);

		}
		
	}

}
