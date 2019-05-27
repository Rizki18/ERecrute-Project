package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Societe implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeSociete;
	private String nomSociete;
	@OneToMany(mappedBy = "Societe", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<Experience> m_Experience;
	
	public Societe() {
		super();
	}

	public Societe(String nomSociete) {
		super();
		this.nomSociete = nomSociete;
	}

	public Long getCodeSociete() {
		return codeSociete;
	}

	public void setCodeSociete(Long codeSociete) {
		this.codeSociete = codeSociete;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public Set<Experience> getM_Experience() {
		return m_Experience;
	}

	public void setM_Experience(Set<Experience> m_Experience) {
		this.m_Experience = m_Experience;
	}

	@Override
	public String toString() {
		return "Societe [codeSociete=" + codeSociete + ", nomSociete=" + nomSociete + ", m_Experience=" + m_Experience
				+ "]";
	}

	public void finalize() throws Throwable {

	}

}