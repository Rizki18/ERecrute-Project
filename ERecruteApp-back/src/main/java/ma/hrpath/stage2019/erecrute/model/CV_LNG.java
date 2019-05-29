package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CV_LNG implements Serializable{

	@Id
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private CV cv;

    @Id
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Langues lng;
    
    private Double niveau;
	private String details;
	
	public CV_LNG() {
		super();
	}

	public CV_LNG(Langues lng, Double niveau, String details) {
		super();
		this.lng = lng;
		this.niveau = niveau;
		this.details = details;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	public Langues getLng() {
		return lng;
	}

	public void setLng(Langues lng) {
		this.lng = lng;
	}

	public Double getNiveau() {
		return niveau;
	}

	public void setNiveau(Double niveau) {
		this.niveau = niveau;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cv == null) ? 0 : cv.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((lng == null) ? 0 : lng.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
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
		CV_LNG other = (CV_LNG) obj;
		if (cv == null) {
			if (other.cv != null)
				return false;
		} else if (!cv.equals(other.cv))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (lng == null) {
			if (other.lng != null)
				return false;
		} else if (!lng.equals(other.lng))
			return false;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CV_LNG [cv=" + cv + ", lng=" + lng + ", niveau=" + niveau + ", details=" + details + "]";
	}
	
	
	
}
