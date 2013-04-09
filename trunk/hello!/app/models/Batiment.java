package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class Batiment extends Model {
	public String nom_bat;
	public double longitude;
	public double latitude;
	public int surface;
	public int capacite;
	
	public Batiment(String nom_bat, double longitude, double latitude,
			int surface, int capacite) {
		this.nom_bat = nom_bat;
		this.longitude = longitude;
		this.latitude = latitude;
		this.surface = surface;
		this.capacite = capacite;
	}
	
}
