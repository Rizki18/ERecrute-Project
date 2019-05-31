package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.HashSet;
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
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CV_SA> m_secteurActivites;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CV_COMP> m_competences;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CV_TP> m_typeProfils;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CV_TC> m_typeContrats;
	
	@OneToMany(mappedBy = "sf", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CV_SF> m_situationFamiliales;
	
	@OneToMany(mappedBy = "lng", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CV_LNG> m_langues;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "cv_exps", 
    	joinColumns = @JoinColumn(name = "cv_id"), 
    	inverseJoinColumns = @JoinColumn(name = "exp_id"))
	@JsonIgnore
	private Set<Experience> exps = new HashSet<>();
	
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

	public void setSecteurActivites(CV_SA ... secteurActivites) {
		for(CV_SA secteurActivite : secteurActivites) secteurActivite.setCv(this);
        this.m_secteurActivites = Stream.of(secteurActivites).collect(Collectors.toSet());
	}

	public Set<CV_COMP> getM_competences() {
		return m_competences;
	}

	public void setM_competences(Set<CV_COMP> m_competences) {
		this.m_competences = m_competences;
	}
	
	public void setCompetences(CV_COMP ... competences) {
        this.m_competences = Stream.of(competences).collect(Collectors.toSet());
	}
	
	public void addCompetence(Competence competence, Double niveau, String details) {
        CV_COMP compCV = new CV_COMP(this,competence,details,niveau);
        this.m_competences.add(compCV);
	}
	
	public Set<CV_TP> getM_typeProfils() {
		return m_typeProfils;
	}

	public void setM_typeProfils(Set<CV_TP> m_typeProfils) {
		this.m_typeProfils = m_typeProfils;
	}

	public void setTypeProfils(CV_TP ... typeProfils) {
		for(CV_TP typeProfil : typeProfils) typeProfil.setCv(this);
        this.m_typeProfils = Stream.of(typeProfils).collect(Collectors.toSet());
	}
	
	public Set<CV_TC> getM_typeContrats() {
		return m_typeContrats;
	}

	public void setM_typeContrats(Set<CV_TC> m_typeContrats) {
		this.m_typeContrats = m_typeContrats;
	}
	
	public void setTypeContarts(CV_TC ... TypeContrats) {
		for(CV_TC typeContrat : TypeContrats) typeContrat.setCv(this);
        this.m_typeContrats = Stream.of(TypeContrats).collect(Collectors.toSet());
	}

	public Set<CV_SF> getM_situationFamiliales() {
		return m_situationFamiliales;
	}

	public void setM_situationFamiliales(Set<CV_SF> m_situationFamiliales) {
		this.m_situationFamiliales = m_situationFamiliales;
	}

	public void setSituationFamiliales(CV_SF ... SituationFamiliales) {
		for(CV_SF situationFamiliale : SituationFamiliales) situationFamiliale.setCv(this);
        this.m_situationFamiliales = Stream.of(SituationFamiliales).collect(Collectors.toSet());
	}
	
	public Set<CV_LNG> getM_langues() {
		return m_langues;
	}

	public void setM_langues(Set<CV_LNG> m_langues) {
		this.m_langues = m_langues;
	}

	public void setLangues(CV_LNG ... Langues) {
		for(CV_LNG langue : Langues) langue.setCv(this);
        this.m_langues = Stream.of(Langues).collect(Collectors.toSet());
	}
	
	public Set<Experience> getExps() {
		return exps;
	}

	public void setExps(Set<Experience> exps) {
		this.exps = exps;
	}
	
	public void addExp(Experience exp) {
		this.exps.add(exp);
	}

	@Override
	public String toString() {
		return "CV [codeCV=" + codeCV + ", modele=" + modele + ", nomCV=" + nomCV + ", posteDesire=" + posteDesire
				+  "]";
	}

	public void finalize() throws Throwable {

	}

}