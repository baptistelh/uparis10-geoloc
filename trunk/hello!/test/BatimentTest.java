import static org.junit.Assert.fail;

import org.junit.*;

import java.util.*;

import play.test.*;
import models.*;

public class BatimentTest extends UnitTest {
	Batiment bat = new Batiment("bat G", 14, 13);

	@Before
	public void setUp() {
		Fixtures.loadModels("data.yml");
	}

	@After
	public void tearDown() {
		Fixtures.deleteAllModels();
	}

	@Test
	public void testFieldsNotNull() {

		assertNotNull(bat.nom);
		assertNotNull(bat.longitude);
		assertNotNull(bat.latitude);
	}

	@Test
	public void testToString() {
		assertEquals("bat G", bat.toString());

	}

	@Test
	public void testFieldsValue() {
		assertEquals("bat G", bat.nom);
		assertTrue(14d == bat.longitude);
		assertTrue(13d == bat.latitude);

		Batiment b = Batiment.all().first();
		assertEquals("batA", b.nom);
		assertTrue(50.4d == b.latitude);
		assertTrue(54.5d == b.longitude);

	}

	@Test
	public void testBatimentsValue() {
		List<Batiment> bat = Batiment.all().fetch();
		assertEquals(3, bat.size());
		assertEquals("batA", bat.get(0).nom);
		assertTrue(50.4d == bat.get(0).latitude);
		System.out.println(bat.get(0).latitude);
		assertEquals("batB", bat.get(1).nom);
		assertTrue(54.6d == bat.get(1).longitude);
		assertEquals("batC", bat.get(2).nom);

	}

	@Test
	public void testActivite() {

		List<BatimentActivite> activite = BatimentActivite.find("batiment.nom",
				"batA").fetch();
		assertEquals(2, activite.size());
		assertEquals("Sport", activite.get(0).activite.libelle);

	}

	@Test
	public void testActivites() {

		List<BatimentActivite> activite = BatimentActivite.find("batiment.nom",
				"batA").fetch();
		assertEquals(2, activite.size());
		assertEquals("Sport", activite.get(0).activite.libelle);
		assertEquals("Cinema", activite.get(1).activite.libelle);

	}
}
