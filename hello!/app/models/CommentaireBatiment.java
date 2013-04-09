package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class CommentaireBatiment extends Model {
	public Utilisateur user;
	public Batiment batiment;
	public String commentaire;
	
	public CommentaireBatiment(Utilisateur user, Batiment batiment,
			String commentaire) {
		this.user = user;
		this.batiment = batiment;
		this.commentaire = commentaire;
	}
}
