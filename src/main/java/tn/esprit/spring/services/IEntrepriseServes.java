package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseServes {
	List<Entreprise> retrieveAllEntreprise(); 
	Entreprise addEntreprise(Entreprise en);
	Entreprise updateEntreprise(Entreprise en);
	void deleteEntreprise(int id);
	Entreprise retrieveEntreprise(int id);	
}

