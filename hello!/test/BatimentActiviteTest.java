

import static org.junit.Assert.*;

import models.Activite;
import models.Batiment;
import models.BatimentActivite;
import models.Description;

import org.junit.Test;

import play.test.UnitTest;

public class BatimentActiviteTest extends UnitTest {

	@Test
	public void batimentNull(){
		Batiment b=new Batiment("batiment G", 2, 48.3);
		Activite a = new Activite("miage");
		BatimentActivite ba= new BatimentActivite(b, a);
		assertNotNull(ba.batiment);	
	}
	
	@Test
	public void activiteNull(){
		Batiment b=new Batiment("batiment G", 2, 48.3);
		Activite a = new Activite("miage");
		BatimentActivite ba= new BatimentActivite(b, a);
		assertNotNull(ba.activite);	
	}
	
	@Test
	public void descriptionsNull(){
		Batiment b=new Batiment("batiment G", 2, 48.3);
		Activite a = new Activite("miage");
		BatimentActivite ba= new BatimentActivite(b, a);
		//Description d= new Description("date de creation", "1936",ba);
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
