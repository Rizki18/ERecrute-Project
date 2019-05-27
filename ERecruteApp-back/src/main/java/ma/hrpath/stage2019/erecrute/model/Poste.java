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
public class Poste implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codePost;
	private String descriptionPoste;
	private String libellePost;
	@OneToMany(mappedBy = "Poste", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<Experience> m_Experience;

	public Poste() {
		super();
	}

	public Poste(String descriptionPoste, String libellePost) {
		super();
		this.descriptionPoste = descriptionPoste;
		this.libellePost = libellePost;
	}

	public Long getCodePost() {
		return codePost;
	}

	public void setCodePost(Long codePost) {
		this.codePost = codePost;
	}

	public String getDescriptionPoste() {
		return descriptionPoste;
	}

	public void setDescriptionPoste(String descriptionPoste) {
		this.descriptionPoste = descriptionPoste;
	}

	public String getLibellePost() {
		return libellePost;
	}

	public void setLibellePost(String libellePost) {
		this.libellePost = libellePost;
	}

	public Set<Experience> getM_Experience() {
		return m_Experience;
	}

	public void setM_Experience(Set<Experience> m_Experience) {
		this.m_Experience = m_Experience;
	}

	@Override
	public String toString() {
		return "Poste [codePost=" + codePost + ", descriptionPoste=" + descriptionPoste + ", libellePost=" + libellePost
				+ ", m_Experience=" + m_Experience + "]";
	}

	public void finalize() throws Throwable {

	}

}