package tn.esprit.spring.services;

import java.util.Set;

import tn.esprit.spring.entities.Assurance;
import tn.esprit.spring.entities.Beneficiaire;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.TypeContrat;

public interface IExamenServices {

	Beneficiaire ajouterBeneficaire(Beneficiaire bf);
	
	Contrat ajouterContrat (Contrat c) ;

	Assurance ajouterAssurance(Assurance a, int cinBf, String matricule);

	Contrat getContratBf(int idBf);

	float getMontantBf(int cinBf);

	Set<Beneficiaire> getBeneficairesByType(TypeContrat tc);

	void statistiques();
	
}
