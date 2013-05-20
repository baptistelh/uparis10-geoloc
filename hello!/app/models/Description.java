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
	@AttributeOverride(column = @Column, name = "batiment_activite")
	public BatimentActivite batimentActivite;
	
	
	public Description(String clef, String valeur, BatimentActivite batimentActivite) {
		this.clef = clef;
		this.valeur = valeur;
		this.batimentActivite = batimentActivite;
		this.batimentActivite.descriptions.add(this);
	}
	
	@Override
	public String toString(){
		return this.clef+" : "+this.valeur;
	}
}
