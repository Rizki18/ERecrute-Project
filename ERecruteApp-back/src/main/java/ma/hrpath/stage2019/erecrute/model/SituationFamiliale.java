package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class SituationFamiliale implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeSituationFamiliale;
	private String civilite;
	
	@OneToMany(mappedBy = "sf", cascade = CascadeType.ALL)
	private Set<CV_SF> m_cvs;
	

	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "SF_MotCles", 
	    	joinColumns = @JoinColumn(name = "SF_id"), 
	    	inverseJoinColumns = @JoinColumn(name = "Motcles_id"))
	    private Set<MotCles> Motcles = new HashSet<>();

	 
	public Set<CV_SF> getM_cvs() {
		return m_cvs;
	}
	public void setM_cvs(Set<CV_SF> m_cvs) {
		this.m_cvs = m_cvs;
	}
	public Set<MotCles> getMotcles() {
		return Motcles;
	}
	public void setMotcles(Set<MotCles> motcles) {
		Motcles = motcles;
	}
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