package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CV_LAN implements Serializable {

	@Id
    @ManyToOne
    @JoinColumn
    private CV cv;

    @Id
    @ManyToOne
    @JoinColumn
    private Langues lan;
    
   	private Date dateDebut;
	private Date dateFin;
	
	public CV_LAN() {
		super();
	}

	public CV_LAN(CV cv, Langues lan, Date dateDebut, Date dateFin) {
		super();
		this.cv = cv;
		this.lan = lan;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	public Langues getLan() {
		return lan;
	}

	public void setLan(Langues lan) {
		this.lan = lan;
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
