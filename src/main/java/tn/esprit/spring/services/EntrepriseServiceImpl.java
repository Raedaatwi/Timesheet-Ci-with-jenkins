package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseServes {
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    EntrepriseRepository ent_repo;
	@Override
	public List<Entreprise> retrieveAllEntreprise() {

		List<Entreprise> Entreprises = null;
		try {

			l.info("entre dans  retrieveAllEntrprise  () : ");
			Entreprises = (List<Entreprise>) ent_repo.findAll();  
			for (Entreprise et : Entreprises) {
				l.debug("user +++ : " + et);
			} 
			l.info("fonction retrieveAllentreprise termine () : ");
		}catch (Exception e) {
			l.error("Error  dans  retrieveAllEntreprise() : " + e);
		}

		return Entreprises;
		
	}

	@Override
	public Entreprise addEntreprise(Entreprise en) {
		try{
			l.info(" ajout de l'entreprise  :");
			return ent_repo.save(en);
		}catch (Exception e) {

			l.error("Error dans l'ajout d'entreprise ");

			return null;
		}

	}

	@Override
	public void deleteEntreprise(int id) {
		try{
		
			ent_repo.deleteById(id);
			l.info("entreprise a ete supprimer ");
		}catch (Exception e) {

			l.error("The entreprise  with id = %d does not Exist",id);
		}
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise en) {
		return ent_repo.save(en);
		
	}

	@Override
	public Entreprise retrieveEntreprise(int id) {
		l.info("in  retrieveEntreprise id = " + id);
		//orElse(null);
		 
		Entreprise E=  ent_repo.findById(id).orElse(null);
		l.info("Entreprise returned : " + E);
		return E; 
	}
	
	

}
