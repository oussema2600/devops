package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assurance implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAssurance;

	private String designation;
	private float montant;
	@ManyToOne(cascade=CascadeType.ALL)
	private Contrat contrat;

	@ManyToOne
	private Beneficiaire beneficiaire;
	

}
