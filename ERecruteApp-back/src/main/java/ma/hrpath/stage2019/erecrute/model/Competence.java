package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Competence implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCompetance;
	private String nomCompetence;
	
	@OneToMany(mappedBy = "comp", cascade = CascadeType.ALL)
	private Set<CV_COMP> m_cvs;
	
	//public MotCLes m_MotCLes;

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