import org.junit.*;
import org.junit.Before;

import controllers.Application;


import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.results.Result;
import models.*;

public class ApplicationTest extends FunctionalTest {
	
	
	@Before
	public void setUp() {
	    Fixtures.deleteDatabase();
	    Fixtures.loadModels("data.yml");
	}

    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
    // Tests des webServices
    @Test
    public void batimentById(){
    	Batiment batTrue= new Batiment("batA", 54.5, 50.4);
    	Batiment batFalse= new Batiment("batA", 54.5, 50.4);
    	//Application.batimentById(1);
    	Response r = GET ("/listeBatimentsXML");
    	System.out.println(r.toString());

   
    }
}