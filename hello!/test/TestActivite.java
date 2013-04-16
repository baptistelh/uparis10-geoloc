import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class TestActivite extends UnitTest {
	Activite a = new Activite("miage");

    
    public void nameNotNullTest() {
    	assertNotNull(a.description);
    }
    
    
}
