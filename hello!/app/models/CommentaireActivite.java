package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class CommentaireActivite {
	public Utilisateur user;
	public Activite activite;
	public String commentaire;
	
	public CommentaireActivite(Utilisateur user, Activite activite,
			String commentaire) {
		this.user = user;
		this.activite = activite;
		this.commentaire = commentaire;
	}
}
