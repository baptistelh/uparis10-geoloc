import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class BatimentTest extends UnitTest{
	
	@Test
    public void nomBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 14, 13);
        assertNotSame(bat.nom.trim(), "");
    }
	

	@Test
    public void latitudeNullBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 2, 48.3);
        assertNotNull(bat.latitude);
    }
	
	@Test
    public void latitudeMinBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 2, 48.3);
        assertTrue(bat.latitude > 48);
    }
	
	@Test
    public void latitudeMaxBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 2, 48.3);
        assertTrue(bat.latitude < 49);
    }
	
	@Test
    public void longitudeNullBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 2, 48.3);
        assertNotNull(bat.longitude);
    }
	
	@Test
    public void longitudeMinBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 2, 48.3);
        assertTrue(bat.longitude > 1);
    }
	
	@Test
    public void longitudeMaxBatiment( ) {
		
		Batiment bat = new Batiment("batiment G", 2, 48.3);
        assertTrue(bat.longitude < 3);
    }
}
