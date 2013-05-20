package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import play.db.jpa.*;

@Entity
@Table(name="Batiment_Activite")
@AttributeOverride(name = "id", column = @Column(name = "num_bat_act"))
public class BatimentActivite extends Model{
	
	@ManyToOne
	@JoinColumn(name = "pk_batiment")
	public Batiment batiment;
	
	@ManyToOne
	@JoinColumn(name = "pk_activite")
	public Activite activite;
	
	@OneToMany(mappedBy = "batimentActivite")
	public List<Description> descriptions = new ArrayList<Description>();
	
	
	public BatimentActivite(Batiment batiment,  Activite activite){
		this.batiment = batiment;
		this.activite = activite;
		
		batiment.activites.add(this);
		activite.batiments.add(this);
	}
	

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.batiment.toString()+" "+this.activite.toString();
	}
}
