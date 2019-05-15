package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class CV_SA implements Serializable{

	@Id
    @ManyToOne
    @JoinColumn
    private CV cv;

    @Id
    @ManyToOne
    @JoinColumn
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
	
}
