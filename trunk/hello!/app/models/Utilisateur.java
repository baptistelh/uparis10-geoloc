package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Utilisateur extends Model {
 
    public String pseudo;
    
    public Utilisateur(String pseudo) {
    	this.pseudo = pseudo;
    }
 
}
