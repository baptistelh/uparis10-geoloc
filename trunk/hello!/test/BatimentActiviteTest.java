import static org.junit.Assert.*;

import java.util.List;

import models.Activite;
import models.Batiment;
import models.BatimentActivite;
import models.Description;
import models.Utilisateur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

public class BatimentActiviteTest extends UnitTest {

	Batiment b = new Batiment("batiment G", 2, 48.3);
	Activite a = new Activite("miage");
	BatimentActivite ba = new BatimentActivite(b, a);
	
	@Before
	public void setUp() {
		Fixtures.loadModels("data.yml");
	}

	@After
	public void tearDown() {
		Fixtures.deleteAllModels();
	}

	@Test
	public void batimentNull() {

		assertNotNull(ba.batiment);
		assertNotNull(ba.activite);
		assertNotNull(ba.descriptions);
		assertEquals(1, ba.batiment.activites.size());
		assertEquals(1, ba.activite.batiments.size());

		assertEquals("miage", ba.batiment.activites.get(0).activite.libelle);
		assertEquals("batiment G", ba.batiment.activites.get(0).batiment.nom);

		assertEquals("miage", ba.activite.batiments.get(0).activite.libelle);
		assertEquals("batiment G", ba.activite.batiments.get(0).batiment.nom);

	}

	@Test
	public void testToString() {
		assertEquals("batiment G miage", ba.toString());

	}
	
	@Test
	public void testUserFields() {

		BatimentActivite batAct = BatimentActivite.all().first();
		assertEquals( "Sport", batAct.activite.libelle);
		assertEquals( "batA", batAct.batiment.nom);
		assertTrue( 50.4d == batAct.batiment.latitude);

	}

	@Test
	public void testUsersFields() {

		List<BatimentActivite> batAct = BatimentActivite.all().fetch();
		assertEquals(4, batAct.size());
		assertTrue(50.4d == batAct.get(0).batiment.latitude);
		assertTrue(54.5d == batAct.get(1).batiment.longitude);
		assertEquals("Sport", batAct.get(2).activite.libelle);
		assertEquals("batC", batAct.get(3).batiment.nom);
		
	}

}
