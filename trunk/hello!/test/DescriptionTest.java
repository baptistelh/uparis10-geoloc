import org.junit.*;

import java.util.*;

import play.test.*;
import models.*;

public class DescriptionTest extends UnitTest {
	Batiment b = new Batiment("G", 78, 76);
	Activite a = new Activite("Historique");
	BatimentActivite batAct = new BatimentActivite(b, a);
	Description d = new Description("date de creation", "1936", batAct);

	@Before
	public void setUp() {
		Fixtures.deleteDatabase();
		Fixtures.loadModels("data.yml");
	}

	@After
	public void tearDown() {
		Fixtures.deleteAllModels();
	}

	@Test
	public void testFieldsNotNull() {
		assertNotNull(d.clef);
		assertNotNull(d.valeur);
		assertNotNull(d.batimentActivite.batiment);
		assertNotNull(d.batimentActivite.activite);
		assertNotNull(d.batimentActivite.descriptions);
		assertEquals(1,d.batimentActivite.descriptions.size());
	}

	@Test
	public void testFieldsValue() {
		assertEquals("date de creation", d.clef);
		Description desc = Description.all().first();
		assertEquals("film", desc.clef);
		assertEquals("ff6", desc.valeur);
		assertEquals("batA", desc.batimentActivite.batiment.nom);
		assertEquals("Sport", desc.batimentActivite.activite.libelle);
		assertEquals("1936", d.valeur);
		assertEquals("G", d.batimentActivite.batiment.nom);
		assertEquals("Historique", d.batimentActivite.activite.libelle);
		assertEquals("date de creation",
				d.batimentActivite.descriptions.get(0).clef);
	}
	
	@Test
	public void testToString() {
		assertEquals("date de creation : 1936", d.toString());

	}
	
	@Test
	public void testDescription() {

		List<Description> desc = Description.find(
				"clef", "film").fetch();
		assertEquals(2, desc.size());
		assertEquals("ff6", desc.get(0).valeur);

	}

	@Test
	public void testDescriptions() {

		List<Description> desc = Description.find(
				"clef", "film").fetch();
		assertEquals(2, desc.size());
		assertEquals("ff6", desc.get(0).valeur);
		assertEquals("ff5", desc.get(1).valeur);

	}
	@Test
	public void testBatimentActivite() {
		List<Description> desc = Description.find(
				"clef", "film").fetch();
		assertEquals(2, desc.get(0).batimentActivite.descriptions.size());
	}

}
