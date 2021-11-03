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

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;

import tn.esprit.spring.services.MissionServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MissionServiceImplTest {
	//try push trigger
	static int id_added;
	
	@Autowired
	MissionServiceImpl mis_sev;
	
	@Test
    @Order(1)
	public void A_testAddMission()  {
		
	
		Mission mis = new Mission ("1", "mission"); 
		Mission misAdded = mis_sev.addMission(mis); 
		id_added = misAdded.getId();
		assertNotNull(misAdded.getId());

	}
	
	@Test
	@Order(3)
	public void B_TestRetreiveMission(){
		Mission Retreivedmis = mis_sev.retrieveMission(id_added);
		Assert.assertNotNull(Retreivedmis);
	}
	@Test
	@Order(4)
	public void C_testModifyMissione() throws ParseException {
		
		Mission mis = mis_sev.retrieveMission(id_added);
		Mission mis_modifyed = mis;
		mis_modifyed.setName("raed");
		Mission MissionUpdated  = mis_sev.updateMission(mis);
		
		Assert.assertTrue(0==mis.getName().compareTo(MissionUpdated.getName()));
	}
	
	
	

	@Test
	@Order(2)
	public void AB_testretrieveAllMissions(){
		assertTrue(mis_sev.retrieveAllMissions().size()>=0);
	

		

	}
	
	@Test
	@AfterAll
	public void D_TestDeleteMission(){
		mis_sev.deleteMission(id_added);
		Assert.assertTrue(mis_sev.retrieveMission(id_added)==null);
	}
 

}
