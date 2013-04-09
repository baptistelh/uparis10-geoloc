import play.test.*;
import models.Utilisateur;

import org.junit.*;

public class TestUtilisateur extends UnitTest {
	
    @Test
    public void aTest() {
        assertEquals(2, 1 + 1); // A really important thing to test
    }
    
    @Test public void testUtilisateurNotNull() {
    	Utilisateur u = new Utilisateur("toto","mdp","toto@mail.com");
    	assertNotNull(u.pseudo);
    	assertNotNull(u.mdp);
    	assertNotNull(u.mail);
    }
    
    
 
    /*@Test
    public void testUsers() {
        assertEquals(3, Utilisateur.count()); 
    }*/

}
