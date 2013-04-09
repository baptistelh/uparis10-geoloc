package models;
 
import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;
 
@Entity
@AttributeOverride(name = "id", column = @Column(name = "num_user"))
public class Utilisateur extends Model {

    public String pseudo;
    public String mdp;
    public String mail;
    
    public Utilisateur(String pseudo, String mdp, String mail) {
    	this.pseudo = pseudo;
    	this.mdp = mdp;
    	this.mail = mail;
    }
 
}
