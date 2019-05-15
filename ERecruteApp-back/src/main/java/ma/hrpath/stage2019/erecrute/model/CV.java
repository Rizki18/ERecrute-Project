package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CV implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCV;
	private String modele;
	private String nomCV;
	private String posteDesire;
	
	//private Profil m_Profil;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	private Set<CV_SA> m_secteurActivites;
	
	public CV() {
		super();
	}

	public CV(String modele, String nomCV,String posteDesire) {
		super();
		this.modele = modele;
		this.nomCV = nomCV;
		this.posteDesire = posteDesire;
		
	}

	public Long getCodeCV() {
		return codeCV;
	}

	public void setCodeCV(Long codeCV) {
		this.codeCV = codeCV;
	}

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

	/*
	public Profil getM_Profil() {
		return m_Profil;
	}

	public void setM_Profil(Profil m_Profil) {
		this.m_Profil = m_Profil;
	}
*/
	public Set<CV_SA> getSecteurActivites() {
		return m_secteurActivites;
	}

	public void setSecteurActivites(CV_SA ... secteurActivites) {
		for(CV_SA secteurActivite : secteurActivites) secteurActivite.setCv(this);
        this.m_secteurActivites = Stream.of(secteurActivites).collect(Collectors.toSet());
	}


	@Override
	public String toString() {
		return "CV [codeCV=" + codeCV + ", modele=" + modele + ", nomCV=" + nomCV + ", posteDesire=" + posteDesire
				+ "]";
	}

	public void finalize() throws Throwable {

	}

}