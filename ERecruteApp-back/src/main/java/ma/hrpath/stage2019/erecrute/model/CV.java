package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;
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
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<CV_SA> m_secteurActivites;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<CV_COMP> m_competences = new HashSet<>();
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<CV_TP> m_typeProfils = new HashSet<>();
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<CV_TC> m_typeContrats = new HashSet<>();
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<CV_SF> m_situationFamiliales = new HashSet<>();
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<CV_LNG> m_langues = new HashSet<>();
	
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
	
	public CV(CV cv) {
		super();
		this.modele = cv.modele;
		this.nomCV = cv.nomCV;
		this.posteDesire = cv.posteDesire;
		this.Profil = cv.Profil;
		this.m_secteurActivites = cv.m_secteurActivites;
		this.m_competences = cv.m_competences;
		this.m_typeProfils = cv.m_typeProfils;
		this.m_typeContrats = cv.m_typeContrats;
		this.m_situationFamiliales = cv.m_situationFamiliales;
		this.m_langues = cv.m_langues;
		this.exps = cv.exps;
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
        this.m_secteurActivites = Stream.of(secteurActivites).collect(Collectors.toSet());
	}

	public void addSecteurActivites(SecteurActivite sa, Date dd, Date df) {
        CV_SA saCV = new CV_SA(this,sa,dd,df);
        this.m_secteurActivites.add(saCV);
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
		this.m_typeProfils = Stream.of(typeProfils).collect(Collectors.toSet());
	}
	
	public void addTypeProfils(TypeProfil tp, Date dd, Date df) {
		CV_TP tpCV = new CV_TP(this,tp,dd,df);
		this.m_typeProfils.add(tpCV);
	}
	
	public Set<CV_TC> getM_typeContrats() {
		return m_typeContrats;
	}

	public void setM_typeContrats(Set<CV_TC> m_typeContrats) {
		this.m_typeContrats = m_typeContrats;
	}
	
	public void setTypeContarts(CV_TC ... TypeContrats) {
		this.m_typeContrats = Stream.of(TypeContrats).collect(Collectors.toSet());
	}
	
	public void addTypeContrats(TypeContrat tc, Date dd, Date df) {
		CV_TC tcCV = new CV_TC(this,tc,dd,df);
		this.m_typeContrats.add(tcCV);
	}

	public Set<CV_SF> getM_situationFamiliales() {
		return m_situationFamiliales;
	}

	public void setM_situationFamiliales(Set<CV_SF> m_situationFamiliales) {
		this.m_situationFamiliales = m_situationFamiliales;
	}

	public void setSituationFamiliales(CV_SF ... SituationFamiliales) {
		this.m_situationFamiliales = Stream.of(SituationFamiliales).collect(Collectors.toSet());
	}
	
	public void addSituationFamiliales(SituationFamiliale sf, Date dd, Date df) {
		CV_SF sfCV = new CV_SF(this,sf,dd,df);
		this.m_situationFamiliales.add(sfCV);
	}
	
	public Set<CV_LNG> getM_langues() {
		return m_langues;
	}

	public void setM_langues(Set<CV_LNG> m_langues) {
		this.m_langues = m_langues;
	}

	public void setLangues(CV_LNG ... Langues) {
		this.m_langues = Stream.of(Langues).collect(Collectors.toSet());
	}
	
	public void addLangues(Langues lng, Double niveau, String details) {
		CV_LNG tpCV = new CV_LNG(this,lng,niveau,details);
		this.m_langues.add(tpCV);
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