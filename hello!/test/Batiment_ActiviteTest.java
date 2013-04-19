

import static org.junit.Assert.*;

import models.Activite;
import models.Batiment;
import models.Batiment_Activite;
import models.Description;

import org.junit.Test;

public class Batiment_ActiviteTest {

	@Test
	public void batimentNull(){
		Batiment b=new Batiment("batiment G", 2, 48.3);
		Activite a = new Activite("miage");
		Batiment_Activite ba= new Batiment_Activite(b, a);
		assertNotNull(ba.batiment);	
	}
	
	@Test
	public void activiteNull(){
		Batiment b=new Batiment("batiment G", 2, 48.3);
		Activite a = new Activite("miage");
		Batiment_Activite ba= new Batiment_Activite(b, a);
		assertNotNull(ba.activite);	
	}
	
	@Test
	public void descriptionsNull(){
		Batiment b=new Batiment("batiment G", 2, 48.3);
		Activite a = new Activite("miage");
		Batiment_Activite ba= new Batiment_Activite(b, a);
		Description d= new Description("date de creation", "1936",ba);
		assertNotNull(ba.descriptions);	
	}
	
	@Test
	public void testBatiment_Activite() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
