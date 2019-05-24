package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CV_COM implements Serializable {

	@Id
    @ManyToOne
    @JoinColumn
    private CV cv;

    @Id
    @ManyToOne
    @JoinColumn
    private Competence com;
    
    private Date dateDebut;
	private Date dateFin;
	
	public CV_COM() {
		super();
	}
	
	public CV_COM(CV cv, Competence com, Date dateDebut, Date dateFin) {
		super();
		this.cv = cv;
		this.com = com;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	public Competence getCom() {
		return com;
	}

	public void setCom(Competence com) {
		this.com = com;
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
