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
	}
	
	@After
	public void tearDown(){
		u = null;
	}
	
	@Test
	public void pseudoUtilisateur() {
		assertEquals("pseudo", u.pseudo);
	}

	@Test
	public void mdpUtilisateur() {
		assertEquals("mdp", u.mdp);
	}

	@Test
	public void capaciteBatiment() {
		assertEquals("mail", u.mail);
	}

}
