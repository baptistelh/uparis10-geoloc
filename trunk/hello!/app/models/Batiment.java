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
	
	@OneToMany(mappedBy = "batiment")
	public List<Batiment_Activite> activites = new ArrayList<Batiment_Activite>();
	
	public Batiment(String nom_bat, double longitude, double latitude) {
		this.nom_bat = nom_bat;
		this.longitude = longitude;
		this.latitude = latitude;
	}	
	
	@Override
	public String toString(){
		return this.nom_bat;
	}
}
