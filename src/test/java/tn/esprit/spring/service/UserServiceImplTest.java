
package tn.esprit.spring.service;

 
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {
	static long id_to_delete   ;
	 long id_to_add;


		@Autowired
		IUserService us; 
	
		@Test
		@Order(4)
		public void C_testRetrieveAllUsers() {
			List<User> listUsers = us.retrieveAllUsers(); 
			// if there are 7 users in DB : 
			assertTrue(listUsers.size()>1);
			
		}
		
		
		@Test
		@Order(1)
		public void A_testAddUser() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User("Mayssa1", "Mayssa1", d, Role.INGENIEUR); 
			User userAdded = us.addUser(u); 
			id_to_delete = userAdded.getId();
			System.out.printf("\n*********************" +userAdded.getId()  , id_to_delete+"*****************");
			Assert.assertEquals(u.getLastName(), userAdded.getLastName());
		}
	 
		@Test
		@Order(2)
		public void B_testModifyUser() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User(5L, "Mayssa122222222", "Mayssa", d, Role.INGENIEUR); 
			User userUpdated  = us.updateUser(u);	
			Assert.assertEquals(u.getLastName(), userUpdated.getLastName());
		}
	
		@Test
		@Order(3)
		public void D_testRetrieveUser() {
			User userRetrieved = us.retrieveUser(id_to_delete); 
			Assert.assertNotNull(userRetrieved);
		}
		
		@Test
		@AfterAll
		public void E_testdeleteuser (){
			us.deleteUser(id_to_delete);
			Assert.assertNull(us.retrieveUser(id_to_delete));
		}
		
		// 5 tests unitaires  
 
}





