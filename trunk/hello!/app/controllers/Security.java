package controllers;

import models.*;

public class Security extends Secure.Security {
	
//    static boolean authenticate(String username, String password) {
//    	if(username.equals("toto") && password.equals("toto"))
//    		return true;
//    	else
//    		return false;
//    }
    
    static boolean authenticate(String username, String password) {
    	Utilisateur u = Utilisateur.find("byPseudo", username).first();
    	if(u!=null && password.equals(u.mdp)) return true;
    	else return false;
    }
    
    static void onDisconnected() {
        Application.index();
    }
    
}