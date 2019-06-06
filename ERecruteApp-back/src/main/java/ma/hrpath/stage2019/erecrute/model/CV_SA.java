package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
public class CV_SA implements Serializable{

	@EmbeddedId
	private CV_SA_ID id_cvSa;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("codeCV")
    private CV cv;

	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("codeSecteurActivite")
    private SecteurActivite sa;
    
    private Date dateDebut;
	private Date dateFin;
	
	public CV_SA() {
		super();
	}

	public CV_SA(CV cv, SecteurActivite sa, Date dateDebut, Date dateFin) {
		super();
		this.id_cvSa = new CV_SA_ID(cv.getCodeCV(),sa.getCodeSecteur());
		this.cv = cv;
		this.sa = sa;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	public SecteurActivite getSa() {
		return sa;
	}

	public void setSa(SecteurActivite sa) {
		this.sa = sa;
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

	@Override
	public String toString() {
		return "CV_SA [cv=" + cv + ", sa=" + sa + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
}
