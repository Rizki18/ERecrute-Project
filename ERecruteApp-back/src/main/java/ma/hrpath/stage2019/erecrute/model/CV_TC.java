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
public class CV_TC implements Serializable{

	@EmbeddedId
	private CV_TC_ID id_cvTc;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("codeCV")
    private CV cv;

	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("codTypeContrat")
    private TypeContrat tc;
    
    private Date dateDebut;
	private Date dateFin;
	
	public CV_TC() {
		super();
	}

	public CV_TC(CV cv, TypeContrat tc, Date dateDebut, Date dateFin) {
		super();
		this.id_cvTc = new CV_TC_ID(cv.getCodeCV(),tc.getCodeTypeContrat());
		this.cv = cv;
		this.tc = tc;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public CV getCv() {
		return cv;
	}


	public void setCv(CV cv) {
		this.cv = cv;
	}


	public TypeContrat getTc() {
		return tc;
	}


	public void setTc(TypeContrat tc) {
		this.tc = tc;
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
		return "CV_TC [cv=" + cv + ", tc=" + tc + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
}
