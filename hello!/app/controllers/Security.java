package controllers;

import models.*;

public class Security extends Secure.Security {
	    
    static boolean authenticate(String username, String password) {
    	Utilisateur u = Utilisateur.find("byPseudo", username).first();
    	if(u!=null){
    		return password.equals(u.mdp);
    	}
    	else return false;
    }
    
    static void onDisconnected() {
        Application.index();
    }
    
}