package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.repository.DepartementRepository;


@Service
public class DepartementServiceImpl implements IDepartementService {
@Autowired
DepartementRepository dep_rep;
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	@Override
	public List<Departement> retrieveAllDepartements() {
		
		List<Departement> Departements = null;
		try {

			l.info("In retrieveAllDepartements() : ");
			Departements = (List<Departement>) dep_rep.findAll();  
			for (Departement dep : Departements) {
				l.debug("user +++ : " + dep);
			} 
			l.info("Out of retrieveAllDepartements() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllDepartements() : " + e);
		}

		return Departements;
	}

	@Override
	public Departement addDepartement(Departement dep) {
		try{
			l.info("Adding Employe To Data Base :");
			return dep_rep.save(dep);
		}catch (Exception e) {
			return null;
		}
	}
	

	@Override
	public void deleteDepartement(int id) {
		
		try{
			l.info("Finding Department with id = %d",id);
			dep_rep.deleteById(id);
			l.info("Department Deleted Successfuly ");
		}catch (Exception e) {

			l.error("The Department with id = %d does not Exist",id);
		}
		
	}

	@Override
	public Departement updateDepartement(Departement dep) {
		
		dep_rep.save(dep);
		return dep;
	}

	@Override
	public Departement retrieveDepartementByid(int id) {
		l.info("in  retrieveDepartementByid id = " + id);
		Departement d =  dep_rep.findById(id).orElse(null); 
		l.info("Employe found : " + d);
		return d; 
		
	}

}
