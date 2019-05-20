package ma.hrpath.stage2019.erecrute.message.request;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ma.hrpath.stage2019.erecrute.model.Profil;

public class CvForm {
	private String modele;
	private String nomCV;
	private String posteDesire;
    private String profil;
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getNomCV() {
		return nomCV;
	}
	public void setNomCV(String nomCV) {
		this.nomCV = nomCV;
	}
	public String getPosteDesire() {
		return posteDesire;
	}
	public void setPosteDesire(String posteDesire) {
		this.posteDesire = posteDesire;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String codeProfil) {
		this.profil = codeProfil;
	}
	
    
}
