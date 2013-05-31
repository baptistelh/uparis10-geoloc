import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import play.test.*;
import models.*;

public class UtilisateurTest extends UnitTest {
	
	Utilisateur u;

	@Before
	public void setUp(){
		u = new Utilisateur("pseudo", "mdp", "mail");	
		Fixtures.loadModels("data.yml");
	}
	
	@After
	public void tearDown(){
		u = null;
		Fixtures.deleteAllModels();
	}
	
	@Test
	public void testLogin() {
		assertEquals("pseudo", u.pseudo);
	}

	@Test
	public void testPwd() {
		assertEquals("mdp", u.mdp);
	}

	@Test
	public void testMail() {
		assertEquals("mail", u.mail);
	}
	
	@Test
	public void testUserFields() {

		Utilisateur user = Utilisateur.all().first();
		assertEquals( "davay@gmail.com", user.mail);
		assertEquals( "secret", user.mdp);
		assertEquals( "daVay", user.pseudo);

	}

	@Test
	public void testUsersFields() {

		List<Utilisateur> users = Utilisateur.all().fetch();
		assertEquals(2, users.size());
		assertEquals("davay@gmail.com", users.get(0).mail);
		assertEquals("azel", users.get(1).pseudo);

	}


}
