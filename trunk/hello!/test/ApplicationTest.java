import java.util.HashMap;
import java.util.Map;

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

	/**
	 * Teste l'accessibilité de la page d'accueil
	 */
    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
    /**
     * Teste l'accessibilité de la page admin
     */
    @Test
    public void testAdminSecurity() {
        Response response = GET("/admin");
        assertStatus(302, response);
        assertHeaderEquals("Location", "/secure/login", response);
    }
    
    /**
     * Teste l'authentification de la page admin
     */
    @Test
    public void testAuthentificationAdmin() {
    	Map<String, String> userParam = new HashMap<String, String>();
    	userParam.put("username", "admin");
    	userParam.put("password", "admin");
    	Response loginResponse = POST("/secure/authenticate", userParam);
    	
    	//On teste la non-redirection vers la page de login
    	assertFalse(loginResponse.getHeader("Location").equals("/secure/login")); 
    	
    	
    	Request request = newRequest();
    	request.cookies = loginResponse.cookies; // this makes the request authenticated
    	request.url = "/activites/list";
    	request.method  = "GET";
        Response response = makeRequest(request);
        assertNull(response.getHeader("Location"));
        assertIsOk(response); // Passes!
        
        //On se déconnecte
        GET("/secure/logout");
        
        //On effectue un autre test pour la non-authentification
        userParam.put("username", userParam.get("username").concat("_False"));
        System.out.println(userParam);
        loginResponse = POST("/secure/authenticate", userParam);
        assertTrue(loginResponse.getHeader("Location").equals("/secure/login"));
        
    }
    
    
    // Tests des webServices
   /* @Test
    public void batimentById(){
    	Batiment batTrue= new Batiment("batA", 54.5, 50.4);
    	Batiment batFalse= new Batiment("batA", 54.5, 50.4);
    	//Application.batimentById(1);
    	Response r = GET ("/listeBatimentsXML");
    	System.out.println(r.toString());

   
    }*/
}