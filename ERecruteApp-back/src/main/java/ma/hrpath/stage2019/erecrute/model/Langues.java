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
public class Langues implements Serializable  {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeLangue;
	private String langue;
	
	@OneToMany(mappedBy = "lng", cascade = CascadeType.ALL)
	private Set<CV_LNG> m_cvs;

	public Langues() {
		super();
	}

	public Langues(Long codeLangue, String langue) {
		super();
		this.codeLangue = codeLangue;
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