package ma.hrpath.stage2019.erecrute.message.request;

import java.util.Date;
import java.util.Set;

public class SaForm {
	private String sa;
	private Date dd;
	private Date df;
	private String Cv;
	private Set<String> mc_sa;
	
	
	public Set<String> getMc_sa() {
		return mc_sa;
	}
	public void setMc_sa(Set<String> mc_sa) {
		this.mc_sa = mc_sa;
	}
	public String getSa() {
		return sa;
	}
	public void setSa(String sa) {
		this.sa = sa;
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
	public String getCv() {
		return Cv;
	}
	public void setCv(String cv) {
		Cv = cv;
	}
	
	
}
