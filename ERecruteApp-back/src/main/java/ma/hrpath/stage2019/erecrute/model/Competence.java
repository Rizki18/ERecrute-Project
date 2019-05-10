package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Competence implements Serializable{
	@Id @GeneratedValue
	private Long codeCompetance;
	private String nomCompetence;
	//public MotCLes m_MotCLes;

	public Competence() {
		super();
	}

	public Competence(Long codeCompetance, String nomCompetence) {
		super();
		this.codeCompetance = codeCompetance;
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