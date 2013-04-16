package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "num_activite"))
public class Activite extends Model {
	
	//@ManyToOne
	//public Batiment batiment;
	public String description;

	public Activite(String description) {
		super();
		this.description = description;
	}
	
//	public Activite(Batiment batiment, String description) {
//		this.batiment = batiment;
//		this.description = description;
//	}
	
	
}
