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
        loginResponse = POST("/secure/authenticate", userParam);
        assertTrue(loginResponse.getHeader("Location").equals("/secure/login"));
        
    }
    
    
    // Tests des webServices
    
    /**
     * On teste l'accessibilité de la page d'accueil de la partie WebServices
     */
    @Test
    public void testThatWebServicesPageWorks() {
    	Response response = GET("/webservices");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
    /**
     * Teste si les webservices dediés au XML renvoient les données au format XML
     */
    @Test
    public void testWebServicesXML() {
    	Response response = GET("/webservices/listeBatimentsXML");
    	assertIsOk(response);
        assertContentType("text/xml", response);
        assertCharset(play.Play.defaultWebEncoding, response);
        
        response = GET("/webservices/listeBatimentsIdXML");
    	assertIsOk(response);
        assertContentType("text/xml", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
    /**
     * Teste si les webservices dediés au JSON renvoient les données au format JSON
     */
    @Test
    public void testWebServicesJSON() {
    	Response response = GET("/webservices/listeBatimentsJSON");
    	assertIsOk(response);
        assertContentType("application/json", response);
        
        response = GET("/webservices/listeBatimentsIdJSON");
    	assertIsOk(response);
        assertContentType("application/json", response);
    }
    
    /**
     * Teste si la page de récupération du batiment à partir de l'id en XML renvoie au format XML
     */
    @Test
    public void testGetBatimentByIdXML() {
    	Map<String, String> userParam = new HashMap<String, String>();
    	Batiment b = Batiment.all().first();
    	Long id = b.id;;
    	userParam.put("id", String.valueOf(id));
    	Response response = POST("/application/batXML", userParam);
    	
    	//On teste la redirection
    	assertStatus(302, response);
        assertHeaderEquals("Location", "/webservices/batimentXML/"+id, response);
    	
        Response newResponse = GET("/webservices/batimentXML/"+id);
        assertIsOk(newResponse);
        assertContentType("text/xml", newResponse);
        assertCharset(play.Play.defaultWebEncoding, newResponse);
    }

    /**
     * Teste si la page de récupération du batiment à partir de l'id en JSON renvoie au format JSON
     */
    @Test
    public void testGetBatimentByIdJSON() {
    	Map<String, String> userParam = new HashMap<String, String>();
    	Batiment b = Batiment.all().first();
    	Long id = b.id;;
    	userParam.put("id", String.valueOf(id));
    	Response response = POST("/application/batJSON", userParam);
    	
    	//On teste la redirection
    	assertStatus(302, response);
        assertHeaderEquals("Location", "/webservices/batimentJSON/"+id, response);
    	
        Response newResponse = GET("/webservices/batimentJSON/"+id);
        assertIsOk(newResponse);
        assertContentType("application/json", newResponse);
    }
}