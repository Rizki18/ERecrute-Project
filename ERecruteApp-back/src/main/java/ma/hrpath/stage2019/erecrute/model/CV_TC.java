package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CV_TC implements Serializable {

	@Id
    @ManyToOne
    @JoinColumn
    private CV cv;

    @Id
    @ManyToOne
    @JoinColumn
    private TypeContrat tc;
    
    private Date dateDebut;
	private Date dateFin;
	
	public CV_TC() {
		super();
	}
	
	public CV_TC(CV cv, TypeContrat tc, Date dateDebut, Date dateFin) {
		super();
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
	
	
	
	
}
