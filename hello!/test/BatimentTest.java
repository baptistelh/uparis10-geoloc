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
        assertNotSame(bat.nom_bat.trim(), "");
    }
	
	@Test
    public void capaciteBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertTrue(bat.capacite> 0);
    }
	
	@Test
    public void latitudeNullBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertNotNull(bat.latitude);
    }
	
	@Test
    public void latitudeMinBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertTrue(bat.latitude > 48);
    }
	
	@Test
    public void latitudeMaxBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertTrue(bat.latitude < 49);
    }
	
	@Test
    public void longitudeNullBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertNotNull(bat.latitude);
    }
	
	@Test
    public void longitudeMinBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertTrue(bat.latitude > 1);
    }
	
	@Test
    public void longitudeMaxBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13, 4, 2);
        assertTrue(bat.latitude < 3);
    }
}
