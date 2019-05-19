package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Formation implements Serializable {

	@Id @GeneratedValue
	private Long id_formation;
	private Date dateDebut;
	private Date dateFin;
	private String details;
	private String etablissement;
	private String intitule;
	private String lieu; 
	@ManyToOne
    @JoinColumn(name = "Profil")
    private Profil Profil;

	public Formation() {
		super();
	}

	public Formation(Long id,Date dateDebut, Date dateFin, String details, String etablissement, String intitule, String lieu) {
		super();
		this.id_formation=id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.details = details;
		this.etablissement = etablissement;
		this.intitule = intitule;
		this.lieu = lieu;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	@Override
	public String toString() {
		return "Formation [id="+id_formation +"dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", details=" + details
				+ ", etablissement=" + etablissement + ", intitule=" + intitule + ", lieu=" + lieu + "]";
	}

	public void finalize() throws Throwable {

	}

	public Long getId_formation() {
		return id_formation;
	}

	public void setId_formation(Long id_formation) {
		this.id_formation = id_formation;
	}

}