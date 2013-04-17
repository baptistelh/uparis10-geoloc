package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "num_description"))
public class Description extends Model {
	
	public String clef;
	public String valeur;
	
	@ManyToOne
	@JoinColumn(name = "pk_bat_act")
	public Batiment_Activite batiment_activite;
	
	
	public Description(String clef, String valeur, Batiment_Activite batiment_activite) {
		this.clef = clef;
		this.valeur = valeur;
		this.batiment_activite = batiment_activite;
	}
	
	@Override
	public String toString(){
		return this.clef+" : "+this.valeur;
	}
}
