package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import play.db.jpa.*;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "num_bat_act"))
public class Batiment_Activite extends Model{
	
	@ManyToOne
	@JoinColumn(name = "pk_batiment")
	public Batiment batiment;
	
	@ManyToOne
	@JoinColumn(name = "pk_activite")
	public Activite activite;
	
	@OneToMany(mappedBy = "batiment_activite")
	public List<Description> descriptions = new ArrayList<Description>();
	
	
	public Batiment_Activite(Batiment batiment,  Activite activite){
		this.batiment = batiment;
		this.activite = activite;
		
		batiment.activites.add(this);
		activite.batiments.add(this);
	}
}
