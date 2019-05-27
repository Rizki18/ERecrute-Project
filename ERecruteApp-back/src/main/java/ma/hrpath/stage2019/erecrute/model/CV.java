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
	
	@ManyToMany(fetch = FetchType.LAZY)
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
				+ ", Profil=" + Profil + ", m_secteurActivites=" + m_secteurActivites + ", exps=" + exps + "]";
	}

	public void finalize() throws Throwable {

	}

}