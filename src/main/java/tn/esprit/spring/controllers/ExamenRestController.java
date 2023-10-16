package tn.esprit.spring.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Assurance;
import tn.esprit.spring.entities.Beneficiaire;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.TypeContrat;
import tn.esprit.spring.services.IExamenServices;



@RestController
@RequestMapping("/examen")
public class ExamenRestController {
	
	@Autowired
	IExamenServices benefServices;
	
	@PostMapping("/addBenef")
	@ResponseBody
	public Beneficiaire addBeneficiaire(@RequestBody Beneficiaire beneficiaire){
		
		return benefServices.ajouterBeneficaire(beneficiaire);
	}
	@PostMapping("/addContrat")
	@ResponseBody
	public Contrat addContrat(@RequestBody Contrat contrat){
		return benefServices.ajouterContrat(contrat);
	}

	@PostMapping("/addAssurance/{cinBf}/{matricule}")
	public Assurance addAssurance(@RequestBody Assurance assurance,
								  @PathVariable("cinBf") int cinBf,
								  @PathVariable("matricule")String matricule){
		return benefServices.ajouterAssurance(assurance, cinBf, matricule);
	}

	@GetMapping("/getContratBf/{id-benef}")
	@ResponseBody
	public Contrat getContratByBf(@PathVariable("id-benef")int idBf){
		return benefServices.getContratBf(idBf);
	}
	@GetMapping("/getBeneficairesByType/{typeC}")
	public Set<Beneficiaire> getBeneficairesByType(@PathVariable("typeC")TypeContrat tc) {
		return benefServices.getBeneficairesByType(tc);
	}
	@GetMapping("/getMontantBf/{cin-benef}")
	public float getMontantBf(@PathVariable("cin-benef") int cinBf){
		return benefServices.getMontantBf(cinBf);
	}
	

}
