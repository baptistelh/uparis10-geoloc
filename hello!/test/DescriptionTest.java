import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;


public class DescriptionTest extends UnitTest{
	Description d;
	Batiment_Activite ba;
	Batiment b;
	Activite a;
	
	@Before
	public void setUp(){
		b = new Batiment("G", 78, 76);
		a = new Activite("Historique");
		ba = new Batiment_Activite(b, a);
		d = new Description("date de creation", "1936", ba);
	}
	
	@Test
	public void testClef(){
		assertEquals(d.clef, "date de creation");
	}
	
	@Test 
	public void testValeur(){
		assertEquals(d.valeur, "1936");
	}
	
	@After
	public void tearDown(){
		d = null;
		ba = null;
		b = null;
		a = null;
	}
}
