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
public class CV_TP implements Serializable{

	@EmbeddedId
	private CV_TP_ID id_cvTp;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("codeCV")
    private CV cv;

	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("codeTypeProfil")
    private TypeProfil tp;
    
    private Date dateDebut;
	private Date dateFin;
	
	public CV_TP() {
		super();
	}

	public CV_TP(CV cv, TypeProfil tp, Date dateDebut, Date dateFin) {
		super();
		this.id_cvTp = new CV_TP_ID(cv.getCodeCV(),tp.getCodeTypeProfil());
		this.cv = cv;
		this.tp = tp;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	public TypeProfil getTp() {
		return tp;
	}

	public void setTp(TypeProfil tp) {
		this.tp = tp;
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
		return "CV_TP [cv=" + cv + ", tp=" + tp + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}

}
