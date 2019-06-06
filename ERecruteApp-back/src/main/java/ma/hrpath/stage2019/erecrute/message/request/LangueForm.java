package ma.hrpath.stage2019.erecrute.message.request;

public class LangueForm {
	private String lng;
	private String niveau;
	private String details;
	private String Cv;
	
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCv() {
		return Cv;
	}
	public void setCv(String cv) {
		Cv = cv;
	}
	@Override
	public String toString() {
		return "LangueForm [lng=" + lng + ", niveau=" + niveau + ", details=" + details + ", Cv=" + Cv + "]";
	}
	
	
}
