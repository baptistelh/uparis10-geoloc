package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class Type_Activite extends Model {
	
	public String desciption;

	public Type_Activite(String desciption) {
		this.desciption = desciption;
	}
}
