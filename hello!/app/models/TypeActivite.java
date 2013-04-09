package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class TypeActivite extends Model {
	
	public String desciption;

	public TypeActivite(String desciption) {
		this.desciption = desciption;
	}
}
