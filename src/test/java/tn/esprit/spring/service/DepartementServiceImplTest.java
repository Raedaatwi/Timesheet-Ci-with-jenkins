package tn.esprit.spring.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.DepartementServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartementServiceImplTest {
	@Autowired
	DepartementServiceImpl dep_service;
	 static int Dep_to_dellete ;


	@Test
	@Order(1)
	public void A_testAddDepartement() {

		Departement Dep = new Departement("Informatique"); 
		Departement DepartementAdded = dep_service.addDepartement(Dep); 
		Dep_to_dellete = DepartementAdded.getId();
		Assert.assertNotNull(DepartementAdded);
	}
	@Test
	@Order(3)
	public void B_RetrieveDepById(){
		Departement Dep =dep_service.retrieveDepartementByid(Dep_to_dellete);
		assertNotNull(Dep);
	}
	
	@Test
	@Order(3)
	public void C_ModifyDepartement()
	{ Departement dep = dep_service.retrieveDepartementByid(Dep_to_dellete);
	
		dep.setName("Mecanique");
		Departement modif =dep_service.updateDepartement(dep);
		Assert.assertTrue(0==modif.getName().compareTo("Mecanique"));;
	}



	@Test
	@Order(4)
	public void D_testRetrieveAllDepartements() {
		List<Departement> ListDepartements = dep_service.retrieveAllDepartements(); 
		assertTrue(ListDepartements.size()>=1);

	}
	@Test
	@Order(5)
	public void E_DeleteDepartementById(){
		dep_service.deleteDepartement(Dep_to_dellete);
		Departement Dep =dep_service.retrieveDepartementByid(Dep_to_dellete);
		Assert.assertNull(Dep);
	}





}
