package ma.hrpath.stage2019.erecrute.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CategorieMotcle {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code_Mot_Cle;
	private String libelle_Mot_Cle;
	@OneToMany(mappedBy = "m_CategorieMotcle", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<MotCles> m_MotsCles;
	
	
	
	public CategorieMotcle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorieMotcle(Long code_Mot_Cle, String libelle_Mot_Cle) {
		super();
		this.code_Mot_Cle = code_Mot_Cle;
		this.libelle_Mot_Cle = libelle_Mot_Cle;
	}
	
	public CategorieMotcle(Long code_Mot_Cle, String libelle_Mot_Cle, Set<MotCles> m_MotsCles) {
		super();
		this.code_Mot_Cle = code_Mot_Cle;
		this.libelle_Mot_Cle = libelle_Mot_Cle;
		this.m_MotsCles = m_MotsCles;
	}
	public Long getCode_Mot_Cle() {
		return code_Mot_Cle;
	}
	public void setCode_Mot_Cle(Long code_Mot_Cle) {
		this.code_Mot_Cle = code_Mot_Cle;
	}
	public String getLibelle_Mot_Cle() {
		return libelle_Mot_Cle;
	}
	public void setLibelle_Mot_Cle(String libelle_Mot_Cle) {
		this.libelle_Mot_Cle = libelle_Mot_Cle;
	}
	public Set<MotCles> getM_MotsCles() {
		return m_MotsCles;
	}
	public void setM_MotsCles(Set<MotCles> m_MotsCles) {
		this.m_MotsCles = m_MotsCles;
	}

}
