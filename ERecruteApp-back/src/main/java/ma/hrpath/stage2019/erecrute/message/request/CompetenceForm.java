package ma.hrpath.stage2019.erecrute.message.request;

import java.util.Set;

public class CompetenceForm {
	private String competence;
	private String niveau;
	private String details;
	private String Cv;
	private Set<String> comp;
	
	public String getCompetence() {
		return competence;
	}
	public void setCompetence(String competence) {
		this.competence = competence;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCv() {
		return Cv;
	}
	public void setCv(String cv) {
		Cv = cv;
	}
	public Set<String> getComp() {
		return comp;
	}
	public void setComp(Set<String> comp) {
		this.comp = comp;
	}
	
	
}
