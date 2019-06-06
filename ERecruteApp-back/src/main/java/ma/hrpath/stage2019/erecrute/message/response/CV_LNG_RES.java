package ma.hrpath.stage2019.erecrute.message.response;

import java.util.Date;

public class CV_LNG_RES {
	private Long lng;
	private String nom;
    private String detail;
	private Double niveau;
	public CV_LNG_RES(Long lng, String nom, String detail, Double niveau) {
		super();
		this.lng = lng;
		this.nom = nom;
		this.detail = detail;
		this.niveau = niveau;
	}
	public Long getLng() {
		return lng;
	}
	public void setLng(Long lng) {
		this.lng = lng;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Double getNiveau() {
		return niveau;
	}
	public void setNiveau(Double niveau) {
		this.niveau = niveau;
	}
	
}
