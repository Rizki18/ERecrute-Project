package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeProfil implements Serializable{
	@Id @GeneratedValue
	private Long codeTyprProfil;
	private String libelleProfil;

	public TypeProfil() {
		super();
	}

	public TypeProfil(Long codeTyprProfil, String libelleProfil) {
		super();
		this.codeTyprProfil = codeTyprProfil;
		this.libelleProfil = libelleProfil;
	}

	public Long getCodeTyprProfil() {
		return codeTyprProfil;
	}

	public void setCodeTyprProfil(Long codeTyprProfil) {
		this.codeTyprProfil = codeTyprProfil;
	}

	public String getLibelleProfil() {
		return libelleProfil;
	}

	public void setLibelleProfil(String libelleProfil) {
		this.libelleProfil = libelleProfil;
	}

	@Override
	public String toString() {
		return "TypeProfil [codeTyprProfil=" + codeTyprProfil + ", libelleProfil=" + libelleProfil + "]";
	}

	public void finalize() throws Throwable {

	}

}