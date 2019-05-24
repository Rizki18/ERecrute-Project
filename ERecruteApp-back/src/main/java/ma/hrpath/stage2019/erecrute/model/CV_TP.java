package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CV_TP implements Serializable {

	@Id
    @ManyToOne
    @JoinColumn
    private CV cv;

    @Id
    @ManyToOne
    @JoinColumn
    private TypeProfil tp;
    
    private Date dateDebut;
	private Date dateFin;
	
	public CV_TP() {
		super();
	}

	public CV_TP(CV cv, TypeProfil tp, Date dateDebut, Date dateFin) {
		super();
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
	
	
	
}
