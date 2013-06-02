package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import models.*;

public class Application extends Controller {
    public static void index() {
    //	Utilisateur u = Utilisateur.find("byPseudo","daVay").first();
    	/*List<Batiment> bl = Batiment.findAll();
    	for(Batiment b : bl){
	    	System.out.println("Batiment "+b);
	    	List<Batiment_Activite> bal = b.activites;
	    	for(Batiment_Activite ba : bal) {
	    		System.out.println("\t"+ba.activite);
	    		for(Description d: ba.descriptions){
	    			System.out.println("\t\t"+d);
	    		}
	    	}
    	}*/
    	List<Batiment> batimentsList = Batiment.findAll(); 	
        render(batimentsList);
    }
	/*
    public static void index() {
    	Utilisateur u = Utilisateur.find("byPseudo","daVay").first();
    	render(u);
    }
    */
    
    public static void webservices() {
    	render();
    }
    
    ///utilisation pour le formulaire
    public static void batXML(int id) {
        redirect("/batimentXML/"+id);
    }
    
    public static void batJSON(int id) {
        redirect("/batimentJSON/"+id);
    }
    ///
    
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
