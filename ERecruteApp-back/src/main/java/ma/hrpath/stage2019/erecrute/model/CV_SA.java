package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
public class CV_SA implements Serializable{

	@Id
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private CV cv;

    @Id
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private SecteurActivite sa;
    
    private Date dateDebut;
	private Date dateFin;
	
	public CV_SA() {
		super();
	}

	public CV_SA(SecteurActivite sa, Date dateDebut, Date dateFin) {
		super();
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cv == null) ? 0 : cv.hashCode());
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((sa == null) ? 0 : sa.hashCode());
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
		CV_SA other = (CV_SA) obj;
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
		if (sa == null) {
			if (other.sa != null)
				return false;
		} else if (!sa.equals(other.sa))
			return false;
		return true;
	}
	
}
