package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SituationFamiliale implements Serializable{

	@Id @GeneratedValue
	private Long codeSituationFamiliale;
	private String civilite;
	

	public SituationFamiliale(){
		super();
	}
	public SituationFamiliale(Long codeSituationFamiliale, String civilite) {
		super();
		this.codeSituationFamiliale = codeSituationFamiliale;
		this.civilite = civilite;
	}
	public Long getCodeSituationFamiliale() {
		return codeSituationFamiliale;
	}

	public void setCodeSituationFamiliale(Long codeSituationFamiliale) {
		this.codeSituationFamiliale = codeSituationFamiliale;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String libelleSecteur) {
		this.civilite = libelleSecteur;
	}

	@Override
	public String toString() {
		return "SituationFamiliale [codeSituationFamiliale=" + codeSituationFamiliale + ", civilite=" + civilite + "]";
	}
	public void finalize() throws Throwable {

	}

}