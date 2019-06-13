package ma.hrpath.stage2019.erecrute.message.request;

import java.util.Date;
import java.util.Set;

public class ExperienceForm {
	private Date dateDebut;
	private Date dateFin;
	private String departement;
	private String descriptionRole;
	private String Poste;
	private String Societe;
	private String Cv;
	private String Profil;
	private Set<String> exp;
	private Set<String> mc_exp;
	
	public Set<String> getMc_exp() {
		return mc_exp;
	}
	public void setMc_exp(Set<String> motsCle) {
		this.mc_exp = motsCle;
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
	public String getPoste() {
		return Poste;
	}
	public void setPoste(String poste) {
		Poste = poste;
	}
	public String getSociete() {
		return Societe;
	}
	public void setSociete(String societe) {
		Societe = societe;
	}
	public String getCv() {
		return Cv;
	}
	public void setCv(String cv) {
		Cv = cv;
	}
	
	public String getProfil() {
		return Profil;
	}
	public void setProfil(String profil) {
		Profil = profil;
	}
	public Set<String> getExp() {
		return exp;
	}
	public void setExp(Set<String> exp) {
		this.exp = exp;
	}
	@Override
	public String toString() {
		return "ExperienceForm [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", departement=" + departement
				+ ", descriptionRole=" + descriptionRole + ", Poste=" + Poste + ", Societe=" + Societe + ", Cv=" + Cv
				+ ", exp=" + exp + "]";
	}
	
	
	
}
