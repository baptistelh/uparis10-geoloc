package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import models.*;

public class Application extends Controller {
    public static void index() {
    	List<Batiment> batimentsList = Batiment.findAll(); 	
        render(batimentsList);
    }
    
    public static void webservices() {
    	render();
    }
    
    //utilisation pour le formulaire
    public static void batXML(int id) {
        redirect("/webservices/batimentXML/"+id);
    }
    
    public static void batJSON(int id) {
        redirect("/webservices/batimentJSON/"+id);
    }
    
    public static void batimentById(int id) {
		Batiment b = Batiment.findById((long)id);
    	render(b);
    }
    
    public static void listeBatiments() {
    	List<Batiment> blist = Batiment.findAll();
    	render(blist);
    }
    
    public static void listeBatimentsId() {
    	List<Batiment> blist = Batiment.findAll();
    	render(blist);
    }
}
