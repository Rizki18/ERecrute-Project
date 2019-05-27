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
public class SecteurActivite implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeSecteur;
	private String libelleSecteur;
	
	@OneToMany(mappedBy = "sa", cascade = CascadeType.ALL)
	private Set<CV_SA> m_cvs;

	public SecteurActivite() {
		super();
	}

	public SecteurActivite(String libelleSecteur) {
		super();
		this.libelleSecteur = libelleSecteur;
	}

	public Long getCodeSecteur() {
		return codeSecteur;
	}

	public void setCodeSecteur(Long codeSecteur) {
		this.codeSecteur = codeSecteur;
	}

	public String getLibelleSecteur() {
		return libelleSecteur;
	}

	public void setLibelleSecteur(String libelleSecteur) {
		this.libelleSecteur = libelleSecteur;
	}

	@Override
	public String toString() {
		return "SecteurActivite [codeSecteur=" + codeSecteur + ", libelleSecteur=" + libelleSecteur + "]";
	}

	public void finalize() throws Throwable {

	}

}