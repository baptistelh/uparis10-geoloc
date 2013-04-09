package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class CommentaireActivite {
	public String commentaire;
	public int num_act;
	public int num_user;
	
	public CommentaireActivite(int user, int act,
			String commentaire) {
		this.num_user = user;
		this.num_act = act;
		this.commentaire = commentaire;
	}
}
