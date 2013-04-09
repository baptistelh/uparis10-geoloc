import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class BatimentTest extends UnitTest{
	
	@Test
    public void surfaceBatiment( ) {
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertTrue(bat.surface> 0);
    }
	
	@Test
    public void nomBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertNotSame(bat.nom_bat, "");
    }
	
	@Test
    public void capaciteBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertTrue(bat.capacite> 0);
    }
	
	@Test
    public void latitudeBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertNotNull(bat.latitude);
    }
	
	@Test
    public void longitudeBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertNotNull(bat.longitude);
    }
}
