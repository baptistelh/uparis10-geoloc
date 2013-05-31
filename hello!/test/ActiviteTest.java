import static org.junit.Assert.*;

import java.util.List;

import models.Activite;
import models.BatimentActivite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

public class ActiviteTest extends UnitTest {

	Activite a = new Activite("Sport");

	@Before
	public void setUp() {
		Fixtures.loadModels("data.yml");
	}

	@After
	public void tearDown() {
		Fixtures.deleteAllModels();
	}

	@Test
	public void testLibelleNotNull() {

		assertNotNull(a.libelle);
	}

	@Test
	public void testLibelleValue() {
		assertEquals("Sport", a.libelle);

		Activite act = Activite.all().first();
		assertEquals("Sport", act.libelle);

	}

	@Test
	public void testLibellesValue() {
		List<Activite> act = Activite.all().fetch();
		assertEquals(2, act.size());
		assertEquals("Sport", act.get(0).libelle);
		assertEquals("Cinema", act.get(1).libelle);

	}

	@Test
	public void testToString() {
		assertEquals("Sport", a.toString());

	}

	@Test
	public void testBatiment() {

		List<BatimentActivite> batiment = BatimentActivite.find(
				"activite.libelle", "Cinema").fetch();
		assertEquals(2, batiment.size());
		assertEquals("batA", batiment.get(0).batiment.nom);

	}

	@Test
	public void testBatiments() {

		List<BatimentActivite> batiment = BatimentActivite.find(
				"activite.libelle", "Sport").fetch();
		assertEquals(2, batiment.size());
		assertEquals("batA", batiment.get(0).batiment.nom);
		assertEquals("batB", batiment.get(1).batiment.nom);

	}
}
