package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CV_SF implements Serializable{

	@EmbeddedId
	private CV_SF_ID id_cvSf;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("codeCV")
    private CV cv;

	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("codeSituationFamiliale")
    private SituationFamiliale sf;
    
    private Date dateDebut;
	private Date dateFin;
	
	
	public CV_SF() {
		super();
	}

	public CV_SF(CV cv, SituationFamiliale sf, Date dateDebut, Date dateFin) {
		super();
		this.id_cvSf = new CV_SF_ID(cv.getCodeCV(),sf.getCodeSituationFamiliale());
		this.cv = cv;
		this.sf = sf;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public CV getCv() {
		return cv;
	}


	public void setCv(CV cv) {
		this.cv = cv;
	}


	public SituationFamiliale getSf() {
		return sf;
	}


	public void setSf(SituationFamiliale sf) {
		this.sf = sf;
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
		return "CV_SF [cv=" + cv + ", sf=" + sf + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
		
}
