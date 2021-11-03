package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartementService {
	List<Departement> retrieveAllDepartements(); 
	Departement addDepartement(Departement dep);
	void deleteDepartement(int id);
	Departement updateDepartement(Departement dep);
	Departement retrieveDepartementByid(int id);
}