package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SituationFamiliale implements Serializable{

	@Id @GeneratedValue
	private Long codeSituationFamiliale;
	private int civilite;
	

	public SituationFamiliale(){

	}

	public void finalize() throws Throwable {

	}

}