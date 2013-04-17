package models;

import java.util.*;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "num_act"))
public class Activite extends Model {

	public String libelle;
	
	@OneToMany(mappedBy = "activite")
	public List<Batiment_Activite> batiments = new ArrayList<Batiment_Activite>();
	
	public Activite(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString(){
		return this.libelle;
	}
}
