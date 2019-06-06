package ma.hrpath.stage2019.erecrute.message.response;

import java.util.Date;

public class CV_SF_RES {
	private Long sf;
	private String nom;
    private Date dd;
	private Date df;
	public CV_SF_RES(Long sf, String nom, Date dd, Date df) {
		super();
		this.sf = sf;
		this.nom = nom;
		this.dd = dd;
		this.df = df;
	}
	public Long getSf() {
		return sf;
	}
	public void setSf(Long sf) {
		this.sf = sf;
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
