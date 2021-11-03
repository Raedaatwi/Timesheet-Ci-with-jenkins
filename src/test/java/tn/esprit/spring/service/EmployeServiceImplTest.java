package tn.esprit.spring.service;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeServiceImplTest {
	//try pushh trigger
	static int id_added;
	
	@Autowired
	EmployeServiceImpl emp_sev;
	
	@Test
    @Order(1)
	public void AA_testAddEmploye()  {
		
	
		Employe emp = new Employe("Bouzayen", "Mohamed","",true, Role.INGENIEUR); 
		Employe empAdded = emp_sev.addEmploye(emp); 
		id_added = empAdded.getId();
		assertNotNull(empAdded.getId());
		
		

	}
	
	@Test
	@Order(3)
	public void B_TestRetreiveEmploye(){
		Employe RetreivedEmp = emp_sev.retrieveEmploye(id_added);
		Assert.assertNotNull(RetreivedEmp);
	}
	@Test
	@Order(4)
	public void C_testModifyEmployee() throws ParseException {
		
		Employe emp = emp_sev.retrieveEmploye(id_added);
		Employe emp_modifyed = emp;
		emp_modifyed.setNom("Bouzayen222222");
		Employe EmployeUpdated  = emp_sev.updateEmploye(emp);
		
		Assert.assertTrue(0==emp.getNom().compareTo(EmployeUpdated.getNom()));
	}
	
	@Test
	@Order(2)
	public void AB_testretrieveAllEmployes(){
		assertTrue(emp_sev.retrieveAllEmployes().size()>=1);


	}
	
	@Test
	@AfterAll
	public void D_TestDeleteEmploye(){
		emp_sev.deleteEmploye(id_added);
		Assert.assertTrue(emp_sev.retrieveEmploye(id_added)==null);
	}
 

}
