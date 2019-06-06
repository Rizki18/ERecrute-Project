package ma.hrpath.stage2019.erecrute.message.response;

import java.util.Date;

public class CV_SA_RES {
	private Long sa;
	private String nom;
    private Date dd;
	private Date df;
	public CV_SA_RES(Long sa, String nom, Date dd, Date df) {
		super();
		this.sa = sa;
		this.nom = nom;
		this.dd = dd;
		this.df = df;
	}
	public Long getSa() {
		return sa;
	}
	public void setSa(Long sa) {
		this.sa = sa;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDd() {
		return dd;
	}
	public void setDd(Date dd) {
		this.dd = dd;
	}
	public Date getDf() {
		return df;
	}
	public void setDf(Date df) {
		this.df = df;
	}
	
	
}
