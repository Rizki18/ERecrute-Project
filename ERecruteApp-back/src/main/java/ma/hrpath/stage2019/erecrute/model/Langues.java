package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Langues implements Serializable  {

	@Id @GeneratedValue
	private Long codeLangue;
	private String langue;

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
		return "Langues [codeLangue=" + codeLangue + ", langue=" + langue + "]";
	}

	public void finalize() throws Throwable {

	}

}