package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "num_UFR"))
public class UFR extends Model {

	public String nom_UFR;

	
	@OneToMany(mappedBy = "ufr")
	public List<Batiment> batiments = new ArrayList<Batiment>();
	
	public UFR(String nom_ufr) {
		this.nom_UFR = nom_ufr;
	}	
	
	@Override
	public String toString(){
		return this.nom_UFR;
	}
}
