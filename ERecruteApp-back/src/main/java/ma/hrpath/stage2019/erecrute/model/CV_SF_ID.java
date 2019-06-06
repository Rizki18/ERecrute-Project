package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CV_SF_ID implements Serializable{
	@Column(name = "code_cv", nullable = false)
	private Long codeCV;
	@Column(name = "code_sf", nullable = false)
	private Long codeSituationFamiliale;
	

	public CV_SF_ID() {
		super();
	}


	public CV_SF_ID(Long codeCV, Long codeSituationFamiliale) {
		super();
		this.codeCV = codeCV;
		this.codeSituationFamiliale = codeSituationFamiliale;
	}


	public Long getCodeCV() {
		return codeCV;
	}


	public void setCodeCV(Long codeCV) {
		this.codeCV = codeCV;
	}


	public Long getCodeSituationFamiliale() {
		return codeSituationFamiliale;
	}


	public void setCodeSituationFamiliale(Long codeSituationFamiliale) {
		this.codeSituationFamiliale = codeSituationFamiliale;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCV == null) ? 0 : codeCV.hashCode());
		result = prime * result + ((codeSituationFamiliale == null) ? 0 : codeSituationFamiliale.hashCode());
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
		CV_SF_ID other = (CV_SF_ID) obj;
		if (codeCV == null) {
			if (other.codeCV != null)
				return false;
		} else if (!codeCV.equals(other.codeCV))
			return false;
		if (codeSituationFamiliale == null) {
			if (other.codeSituationFamiliale != null)
				return false;
		} else if (!codeSituationFamiliale.equals(other.codeSituationFamiliale))
			return false;
		return true;
	}
	
}
