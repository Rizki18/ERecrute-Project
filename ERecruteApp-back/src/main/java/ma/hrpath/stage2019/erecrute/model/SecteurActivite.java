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

@Entity
public class SecteurActivite implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeSecteur;
	private String libelleSecteur;
	
	@OneToMany(mappedBy = "sa", cascade = CascadeType.ALL)
	private Set<CV_SA> m_cvs;

	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "SA_MotCles", 
	    	joinColumns = @JoinColumn(name = "sa_id"), 
	    	inverseJoinColumns = @JoinColumn(name = "Motcles_id"))
	    private Set<MotCles> Motcles = new HashSet<>();

	 
	public Set<CV_SA> getM_cvs() {
		return m_cvs;
	}

	public void setM_cvs(Set<CV_SA> m_cvs) {
		this.m_cvs = m_cvs;
	}

	public Set<MotCles> getMotcles() {
		return Motcles;
	}

	public void setMotcles(Set<MotCles> motcles) {
		Motcles = motcles;
	}

	public SecteurActivite() {
		super();
	}

	public SecteurActivite(String libelleSecteur) {
		super();
		this.libelleSecteur = libelleSecteur;
		this.Motcles = new HashSet<MotCles>();
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