package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Experience implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeExperience;
	private Date dateDebut;
	private Date dateFin;
	private String departement;
	private String descriptionRole;
	//public MotCLes m_MotCLes;
	@ManyToOne
    @JoinColumn(name = "Poste")
	@JsonIgnore
	public Poste Poste;
	@ManyToOne
    @JoinColumn(name = "Societe")
	@JsonIgnore
	public Societe Societe;

	public Experience() {
		super();
	}

	public Experience(Date dateDebut, Date dateFin, String departement, String descriptionRole) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.departement = departement;
		this.descriptionRole = descriptionRole;
	}

	public Long getCodeExperience() {
		return codeExperience;
	}

	public void setCodeExperience(Long codeExperience) {
		this.codeExperience = codeExperience;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getDescriptionRole() {
		return descriptionRole;
	}

	public void setDescriptionRole(String descriptionRole) {
		this.descriptionRole = descriptionRole;
	}

	public Poste getPoste() {
		return Poste;
	}

	public void setPoste(Poste poste) {
		Poste = poste;
	}

	public Societe getSociete() {
		return Societe;
	}

	public void setSociete(Societe societe) {
		Societe = societe;
	}

	@Override
	public String toString() {
		return "Experiencee [codeExperience=" + codeExperience + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", departement=" + departement + ", descriptionRole=" + descriptionRole
				+ ", m_Poste=" + Poste + ", m_Societe=" + Societe + "]";
	}

	public void finalize() throws Throwable {

	}

}