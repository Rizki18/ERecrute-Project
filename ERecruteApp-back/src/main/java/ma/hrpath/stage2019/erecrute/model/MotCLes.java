package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MotCLes implements Serializable {
	@Id @GeneratedValue
	private Long codeMotCle;
	private String libelleMotCle;
	public CategorieMotcle m_CategorieMotcle;
	//public Poste m_Poste;
	//public Profil m_Profil;
	public SecteurActivite m_SecteurActivite;
	
	public MotCLes() {
		super();
	}

	public MotCLes(Long codeMotCle, String libelleMotCle, CategorieMotcle m_CategorieMotcle, SecteurActivite m_SecteurActivite) {
		super();
		this.codeMotCle = codeMotCle;
		this.libelleMotCle = libelleMotCle;
		this.m_CategorieMotcle = m_CategorieMotcle;
		//this.m_Poste = m_Poste;
		//this.m_Profil = m_Profil;
		this.m_SecteurActivite = m_SecteurActivite;
	}

	public Long getCodeMotCle() {
		return codeMotCle;
	}

	public void setCodeMotCle(Long codeMotCle) {
		this.codeMotCle = codeMotCle;
	}

	public String getLibelleMotCle() {
		return libelleMotCle;
	}

	public void setLibelleMotCle(String libelleMotCle) {
		this.libelleMotCle = libelleMotCle;
	}

	public CategorieMotcle getM_CategorieMotcle() {
		return m_CategorieMotcle;
	}

	public void setM_CategorieMotcle(CategorieMotcle m_CategorieMotcle) {
		this.m_CategorieMotcle = m_CategorieMotcle;
	}

	/*public Poste getM_Poste() {
		return m_Poste;
	}

	public void setM_Poste(Poste m_Poste) {
		this.m_Poste = m_Poste;
	}

	public Profil getM_Profil() {
		return m_Profil;
	}

	public void setM_Profil(Profil m_Profil) {
		this.m_Profil = m_Profil;
	}*/

	public SecteurActivite getM_SecteurActivite() {
		return m_SecteurActivite;
	}

	public void setM_SecteurActivite(SecteurActivite m_SecteurActivite) {
		this.m_SecteurActivite = m_SecteurActivite;
	}
	
	

	@Override
	public String toString() {
		return "MotCLes [codeMotCle=" + codeMotCle + ", libelleMotCle=" + libelleMotCle + ", m_CategorieMotcle="
				+ m_CategorieMotcle + ",  m_SecteurActivite="
				+ m_SecteurActivite + "]";
	}

	public void finalize() throws Throwable {

	}

}