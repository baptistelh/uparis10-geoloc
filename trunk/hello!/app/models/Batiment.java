package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
@AttributeOverrides({
@AttributeOverride(name = "id", column = @Column(name = "num_bat")),
@AttributeOverride(name = "nom", column = @Column(name = "nom_bat"))
})
public class Batiment extends Model {

	public String nom;
	public double latitude;
	public double longitude;	
	
	@OneToMany(mappedBy = "batiment")
	public List<BatimentActivite> activites = new ArrayList<BatimentActivite>();
	
	public Batiment(String nom, double longitude, double latitude) {
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
	}	
	
	@Override
	public String toString(){
		return this.nom;
	}
}
