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
public class CV_LNG implements Serializable{

	@EmbeddedId
	private CV_LNG_ID id_cvLng;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("codeCV")
    private CV cv;

	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("codeLangue")
    private Langues lng;
    
    private Double niveau;
	private String details;
	
	public CV_LNG() {
		super();
	}

	public CV_LNG(CV cv, Langues lng, Double niveau, String details) {
		super();
		this.id_cvLng = new CV_LNG_ID(cv.getCodeCV(),lng.getCodeLangue());
		this.cv = cv;
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
	public String toString() {
		return "CV_LNG [cv=" + cv + ", lng=" + lng + ", niveau=" + niveau + ", details=" + details + "]";
	}
	
	
	
}
