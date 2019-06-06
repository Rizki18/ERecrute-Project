package ma.hrpath.stage2019.erecrute.message.response;

import java.util.Date;

public class CV_TC_RES {
	private Long tc;
	private String nom;
    private Date dd;
	private Date df;
	public CV_TC_RES(Long tc, String nom, Date dd, Date df) {
		super();
		this.tc = tc;
		this.nom = nom;
		this.dd = dd;
		this.df = df;
	}
	public Long getTc() {
		return tc;
	}
	public void setTc(Long tc) {
		this.tc = tc;
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
