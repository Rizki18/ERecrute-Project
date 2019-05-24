package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CV implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCV;
	private String modele;
	private String nomCV;
	private String posteDesire;
	@ManyToOne
    @JoinColumn(name = "Profil")
	@JsonIgnore
    private Profil Profil;
	
	//private Profil m_Profil;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	private Set<CV_SA> m_secteurActivites;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	private Set<CV_COM> m_competences;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	private Set<CV_LAN> m_langues;

	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	private Set<CV_SF> m_situationFamiliales;

	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	private Set<CV_TP> m_typeProfil;

	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	private Set<CV_TC> m_typeContrat;
	 
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

	public Profil getProfil() {
		return Profil;
	}

	public void setProfil(Profil profil) {
		Profil = profil;
	}

	public Set<CV_SA> getM_secteurActivites() {
		return m_secteurActivites;
	}

	public void setM_secteurActivites(Set<CV_SA> m_secteurActivites) {
		this.m_secteurActivites = m_secteurActivites;
	}

	
	public Set<CV_COM> getM_competences() {
		return m_competences;
	}

	public void setM_competences(Set<CV_COM> m_competences) {
		this.m_competences = m_competences;
	}

	public Set<CV_LAN> getM_langues() {
		return m_langues;
	}

	public void setM_langues(Set<CV_LAN> m_langues) {
		this.m_langues = m_langues;
	}

	public Set<CV_SF> getM_situationFamiliales() {
		return m_situationFamiliales;
	}

	public void setM_situationFamiliales(Set<CV_SF> m_situationFamiliales) {
		this.m_situationFamiliales = m_situationFamiliales;
	}

	public Set<CV_TP> getM_typeProfil() {
		return m_typeProfil;
	}

	public void setM_typeProfil(Set<CV_TP> m_typeProfil) {
		this.m_typeProfil = m_typeProfil;
	}

	public Set<CV_TC> getM_typeContrat() {
		return m_typeContrat;
	}

	public void setM_typeContrat(Set<CV_TC> m_typeContrat) {
		this.m_typeContrat = m_typeContrat;
	}

	public Set<CV_SA> getSecteurActivites() {
		return m_secteurActivites;
	}

	public void setSecteurActivites(CV_SA ... secteurActivites) {
		for(CV_SA secteurActivite : secteurActivites) secteurActivite.setCv(this);
        this.m_secteurActivites = Stream.of(secteurActivites).collect(Collectors.toSet());
	}
	 
	public void setSituationFamiliale(CV_SF ... situationFamiliales) {
		for(CV_SF situationFamiliale : situationFamiliales) situationFamiliale.setCv(this);
        this.m_situationFamiliales = Stream.of(situationFamiliales).collect(Collectors.toSet());
	}
	
	public void setLangues(CV_LAN ... langues) {
		for(CV_LAN langue : langues) langue.setCv(this);
        this.m_langues = Stream.of(langues).collect(Collectors.toSet());
	}
	
	public void setCompetence(CV_COM ... competences) {
		for(CV_COM competence : competences) competence.setCv(this);
        this.m_competences = Stream.of(competences).collect(Collectors.toSet());
	}

	public void setTypeContrat(CV_TC ... typeContrats) {
		for(CV_TC typeContrat : typeContrats) typeContrat.setCv(this);
        this.m_typeContrat = Stream.of(typeContrats).collect(Collectors.toSet());
	}
	
	public void setTypeProfil(CV_TP ... typeProfils) {
		for(CV_TP typeProfil : typeProfils) typeProfil.setCv(this);
        this.m_typeProfil = Stream.of(typeProfils).collect(Collectors.toSet());
	}


	@Override
	public String toString() {
		return "CV [codeCV=" + codeCV + ", modele=" + modele + ", nomCV=" + nomCV + ", posteDesire=" + posteDesire
				+ "]";
	}

	public void finalize() throws Throwable {

	}

}