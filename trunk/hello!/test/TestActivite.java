import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class TestActivite extends UnitTest {
	Batiment b = new Batiment("G", 1.203, 1.110, 32, 300);
	Activite a = new Activite(b,"miage");

    @Test
    public void containsBatimentTest() {
    	assertNotNull(a.batiment);
    }
    
    public void nameNotNullTest() {
    	assertNotNull(a.description);
    }
    
    
}
