package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Profil implements Serializable  {

	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeProfil;
	private String adresse;
	private String cimr;
	private String cin;
	private String civilite;
	private String cnss;
	private Date dateNaissance;
	private String email;
	private String nom;
	private String permisConduite;
	private String photo;
	private String prenom;
	private String rib;
	private String tel;
	@OneToMany(mappedBy = "Profil", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<Formation> m_Formation;
	@OneToMany(mappedBy = "Profil", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<CV> m_CV;

	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "Profil_MotCles", 
	    	joinColumns = @JoinColumn(name = "profil_id"), 
	    	inverseJoinColumns = @JoinColumn(name = "Motcles_id"))
	    private Set<MotCles> Motcles = new HashSet<>();

	public Set<MotCles> getMotcles() {
		return Motcles;
	}
	public void setMotcles(Set<MotCles> motcles) {
		Motcles = motcles;
	}
	public Profil ()
	{
		super();
	}
	public Profil(Long codeProfil, String adresse, String cimr, String cin, String civilite, String cnss,
			Date dateNaissance, String email, String nom, String permisConduite, String photo, String prenom,
			String rib, String tel, Set<Formation> m_Formation) {
		super();
		this.codeProfil = codeProfil;
		this.adresse = adresse;
		this.cimr = cimr;
		this.cin = cin;
		this.civilite = civilite;
		this.cnss = cnss;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.nom = nom;
		this.permisConduite = permisConduite;
		this.photo = photo;
		this.prenom = prenom;
		this.rib = rib;
		this.tel = tel;
		this.m_Formation = m_Formation;
		this.Motcles = new HashSet<MotCles>();
	}

	public Long getCodeProfil() {
		return codeProfil;
	}

	public void setCodeProfil(Long codeProfil) {
		this.codeProfil = codeProfil;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCimr() {
		return cimr;
	}

	public void setCimr(String cimr) {
		this.cimr = cimr;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getCnss() {
		return cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPermisConduite() {
		return permisConduite;
	}

	public void setPermisConduite(String permisConduite) {
		this.permisConduite = permisConduite;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Set<Formation> getM_Formation() {
		return m_Formation;
	}

	public void setM_Formation(Set<Formation> m_Formation) {
		this.m_Formation = m_Formation;
	}


	public Set<CV> getM_CV() {
		return m_CV;
	}
	public void setM_CV(Set<CV> m_CV) {
		this.m_CV = m_CV;
	}
	@Override
	public String toString() {
		return "Profil [codeProfil=" + codeProfil + ", adresse=" + adresse + ", cimr=" + cimr + ", cin=" + cin
				+ ", civilite=" + civilite + ", cnss=" + cnss + ", dateNaissance=" + dateNaissance + ", email=" + email
				+ ", nom=" + nom + ", permisConduite=" + permisConduite + ", photo=" + photo + ", prenom=" + prenom
				+ ", rib=" + rib + ", tel=" + tel + "]";
	}

	public void finalize() throws Throwable {

	}

}