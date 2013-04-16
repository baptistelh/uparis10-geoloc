package models;

import java.util.*;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "num_bat"))
public class Batiment extends Model {

	public String nom_bat;
	public double longitude;
	public double latitude;
	
	@OneToMany
	public List<Activite> activites;
	
	public Batiment(String nom_bat, double longitude, double latitude) {
		this.nom_bat = nom_bat;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
}
