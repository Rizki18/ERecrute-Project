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
public class TypeProfil implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeTypeProfil;
	private String libelleProfil;
	
	@OneToMany(mappedBy = "tp", cascade = CascadeType.ALL)
	private Set<CV_TP> m_cvs;

	public TypeProfil() {
		super();
	}

	public TypeProfil(Long codeTypeProfil, String libelleProfil) {
		super();
		this.codeTypeProfil = codeTypeProfil;
		this.libelleProfil = libelleProfil;
	}

	public Long getCodeTypeProfil() {
		return codeTypeProfil;
	}

	public void setCodeTypeProfil(Long codeTypeProfil) {
		this.codeTypeProfil = codeTypeProfil;
	}

	public String getLibelleProfil() {
		return libelleProfil;
	}

	public void setLibelleProfil(String libelleProfil) {
		this.libelleProfil = libelleProfil;
	}

	@Override
	public String toString() {
		return "TypeProfil [codeTypeProfil=" + codeTypeProfil + ", libelleProfil=" + libelleProfil + "]";
	}

	public void finalize() throws Throwable {

	}

}