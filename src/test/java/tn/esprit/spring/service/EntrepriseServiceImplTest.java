package tn.esprit.spring.service;

import static org.junit.Assert.assertNotNull;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EntrepriseServiceImplTest {
	@Autowired
	EntrepriseServiceImpl ent_sev;
	static int id_to_delete ;
	

	
	@Test
	@Order(1)
	public void AtestAddEntreprise()  {
		
	
		Entreprise ent = new Entreprise("esprit","esprit"); 
		Entreprise entAdded = ent_sev.addEntreprise(ent); 
		this.id_to_delete =entAdded.getId();
		assertNotNull(entAdded);
	}
	
	@Test
	@Order(2)
	public void B_TestRetreiveEntreprise(){
		Entreprise RetreivedEentreprise = ent_sev.retrieveEntreprise(id_to_delete);
		Assert.assertNotNull(RetreivedEentreprise);
	}
	

	
	@Test
	@Order(3)
	public void C_testModifyEntreprisee()  {
		
		Entreprise entr = ent_sev.retrieveEntreprise(id_to_delete);
		Entreprise entr_modifyed = entr;
		entr_modifyed.setName("Esprit222");
		Entreprise EntrepriseUpdated  = ent_sev.updateEntreprise(entr_modifyed);
		
		Assert.assertTrue(0==entr_modifyed.getName().compareTo(EntrepriseUpdated.getName()));
	}
	@Test
	@Order(4)
	public void DtestretrieveAllEntreprises(){
		
	Assert.assertTrue(ent_sev.retrieveAllEntreprise().size()>=1);
	

	}
	@Test
	@AfterAll
	public void ETestDeleteEntreprise(){
		ent_sev.deleteEntreprise(id_to_delete);
		Assert.assertNull(ent_sev.retrieveEntreprise(id_to_delete));
	}
 
}
