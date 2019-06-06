package ma.hrpath.stage2019.erecrute.message.response;

import java.io.Serializable;

import ma.hrpath.stage2019.erecrute.model.Competence;

public class CV_COMP_RES implements Serializable{
	private Long comp;
	private String nom;
    private String detail;
	private Double niveau;
	public CV_COMP_RES(Long comp,String nom, String detail, Double niveau) {
		super();
		this.nom = nom;
		this.comp = comp;
		this.detail = detail;
		this.niveau = niveau;
	}
	
	public Long getComp() {
		return comp;
	}

	public void setComp(Long comp) {
		this.comp = comp;
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
