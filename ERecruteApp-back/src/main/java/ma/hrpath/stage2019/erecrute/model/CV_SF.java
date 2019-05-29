package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CV_SF implements Serializable{

	@Id
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private CV cv;

    @Id
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private SituationFamiliale sf;
    
    private Date dateDebut;
	private Date dateFin;
	
	
	public CV_SF() {
		super();
	}


	public CV_SF(SituationFamiliale sf, Date dateDebut, Date dateFin) {
		super();
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cv == null) ? 0 : cv.hashCode());
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((sf == null) ? 0 : sf.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CV_SF other = (CV_SF) obj;
		if (cv == null) {
			if (other.cv != null)
				return false;
		} else if (!cv.equals(other.cv))
			return false;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (sf == null) {
			if (other.sf != null)
				return false;
		} else if (!sf.equals(other.sf))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CV_SF [cv=" + cv + ", sf=" + sf + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
		
}
