package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CV_TP_ID implements Serializable{
	@Column(name = "code_cv", nullable = false)
	private Long codeCV;
	@Column(name = "code_tp", nullable = false)
	private Long codeTypeProfil;
	public CV_TP_ID() {
		super();
	}
	public CV_TP_ID(Long codeCV, Long codeTypeProfil) {
		super();
		this.codeCV = codeCV;
		this.codeTypeProfil = codeTypeProfil;
	}
	public Long getCodeCV() {
		return codeCV;
	}
	public void setCodeCV(Long codeCV) {
		this.codeCV = codeCV;
	}
	public Long getCodeTypeProfil() {
		return codeTypeProfil;
	}
	public void setCodeTypeProfil(Long codeTypeProfil) {
		this.codeTypeProfil = codeTypeProfil;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCV == null) ? 0 : codeCV.hashCode());
		result = prime * result + ((codeTypeProfil == null) ? 0 : codeTypeProfil.hashCode());
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
		CV_TP_ID other = (CV_TP_ID) obj;
		if (codeCV == null) {
			if (other.codeCV != null)
				return false;
		} else if (!codeCV.equals(other.codeCV))
			return false;
		if (codeTypeProfil == null) {
			if (other.codeTypeProfil != null)
				return false;
		} else if (!codeTypeProfil.equals(other.codeTypeProfil))
			return false;
		return true;
	}
	
}
