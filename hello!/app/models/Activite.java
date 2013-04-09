package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class Activite extends Model {
	
	public TypeActivite type;
	public Batiment batiment;
	public String description;
	
	public Activite(TypeActivite type, Batiment batiment, String description) {
		this.type = type;
		this.batiment = batiment;
		this.description = description;
	}
}
