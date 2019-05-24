package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CV_SF implements Serializable {

	@Id
    @ManyToOne
    @JoinColumn
    private CV cv;

    @Id
    @ManyToOne
    @JoinColumn
    private SituationFamiliale sf;
    
    private Date dateDebut;
	private Date dateFin;
	
	public CV_SF() {
		super();
	}
	public CV_SF(CV cv, SituationFamiliale sf, Date dateDebut, Date dateFin) {
		super();
		this.cv = cv;
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
	
	
	
}
