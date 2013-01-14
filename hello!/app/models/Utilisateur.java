package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Utilisateur extends Model {
 
    public String prenom;
    public String nom;
    
    public Utilisateur(String prenom, String nom) {
    	this.prenom = prenom;
	this.nom = nom;
    }
 
}
