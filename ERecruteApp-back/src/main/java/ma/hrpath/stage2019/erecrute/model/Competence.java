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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Competence implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCompetance;
	private String nomCompetence;
	
	@OneToMany(mappedBy = "comp", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CV_COMP> m_cvs;

	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "Comp_MotCles", 
	    	joinColumns = @JoinColumn(name = "comp_id"), 
	    	inverseJoinColumns = @JoinColumn(name = "Motcles_id"))
	    private Set<MotCles> Motcles = new HashSet<>();

	public Set<CV_COMP> getM_cvs() {
		return m_cvs;
	}

	public void setM_cvs(Set<CV_COMP> m_cvs) {
		this.m_cvs = m_cvs;
	}

	public Set<MotCles> getMotcles() {
		return Motcles;
	}

	public void setMotcles(Set<MotCles> motcles) {
		Motcles = motcles;
	}

	public Competence() {
		super();
	}

	public Competence(String nomCompetence) {
		super();
		this.nomCompetence = nomCompetence;
		//this.m_MotCLes = m_MotCLes;
	}

	public Long getCodeCompetance() {
		return codeCompetance;
	}

	public void setCodeCompetance(Long codeCompetance) {
		this.codeCompetance = codeCompetance;
	}

	public String getNomCompetence() {
		return nomCompetence;
	}

	public void setNomCompetence(String nomCompetence) {
		this.nomCompetence = nomCompetence;
	}

	/*public MotCLes getM_MotCLes() {
		return m_MotCLes;
	}

	public void setM_MotCLes(MotCLes m_MotCLes) {
		this.m_MotCLes = m_MotCLes;
	}*/

	@Override
	public String toString() {
		return "Competence [codeCompetance=" + codeCompetance + ", nomCompetence=" + nomCompetence +  "]";
	}

	public void finalize() throws Throwable {

	}

}