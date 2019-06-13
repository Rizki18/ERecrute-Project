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
public class Langues implements Serializable  {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeLangue;
	private String langue;
	
	@OneToMany(mappedBy = "lng", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CV_LNG> m_cvs;

	 
	public Set<CV_LNG> getM_cvs() {
		return m_cvs;
	}

	public void setM_cvs(Set<CV_LNG> m_cvs) {
		this.m_cvs = m_cvs;
	}


	public Langues() {
		super();
	}

	public Langues(String langue) {
		super();
		this.langue = langue;
	}

	public Long getCodeLangue() {
		return codeLangue;
	}

	public void setCodeLangue(Long codeLangue) {
		this.codeLangue = codeLangue;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	@Override
	public String toString() {
		return "Langues [codeLangue=" + codeLangue + ", langue=" + langue + ", m_cvs=" + m_cvs + "]";
	}

	public void finalize() throws Throwable {

	}

}