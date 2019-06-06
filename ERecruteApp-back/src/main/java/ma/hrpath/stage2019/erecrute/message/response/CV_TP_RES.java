package ma.hrpath.stage2019.erecrute.message.response;

import java.util.Date;

public class CV_TP_RES {
	private Long tp;
	private String nom;
    private Date dd;
	private Date df;
	public CV_TP_RES(Long tp, String nom, Date dd, Date df) {
		super();
		this.tp = tp;
		this.nom = nom;
		this.dd = dd;
		this.df = df;
	}
	public Long getTp() {
		return tp;
	}
	public void setTp(Long tp) {
		this.tp = tp;
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
