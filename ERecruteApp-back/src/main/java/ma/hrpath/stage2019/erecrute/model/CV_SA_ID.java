package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CV_SA_ID implements Serializable{
	@Column(name = "code_cv", nullable = false)
	private Long codeCV;
	@Column(name = "code_sa", nullable = false)
	private Long codeSecteurActivite;
	public CV_SA_ID() {
		super();
	}
	public CV_SA_ID(Long codeCV, Long codeSecteurActivite) {
		super();
		this.codeCV = codeCV;
		this.codeSecteurActivite = codeSecteurActivite;
	}
	public Long getCodeCV() {
		return codeCV;
	}
	public void setCodeCV(Long codeCV) {
		this.codeCV = codeCV;
	}
	public Long getCodeSecteurActivite() {
		return codeSecteurActivite;
	}
	public void setCodeSecteurActivite(Long codeSecteurActivite) {
		this.codeSecteurActivite = codeSecteurActivite;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCV == null) ? 0 : codeCV.hashCode());
		result = prime * result + ((codeSecteurActivite == null) ? 0 : codeSecteurActivite.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CV_SA_ID other = (CV_SA_ID) obj;
		if (codeCV == null) {
			if (other.codeCV != null)
				return false;
		} else if (!codeCV.equals(other.codeCV))
			return false;
		if (codeSecteurActivite == null) {
			if (other.codeSecteurActivite != null)
				return false;
		} else if (!codeSecteurActivite.equals(other.codeSecteurActivite))
			return false;
		return true;
	}
	
}
