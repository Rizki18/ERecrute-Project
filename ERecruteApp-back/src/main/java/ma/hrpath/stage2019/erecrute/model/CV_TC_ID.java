package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CV_TC_ID implements Serializable{
	@Column(name = "code_cv", nullable = false)
	private Long codeCV;
	@Column(name = "code_tc", nullable = false)
	private Long codeTypeCont;
	public CV_TC_ID() {
		super();
	}
	public CV_TC_ID(Long codeCV, Long codeTypeCont) {
		super();
		this.codeCV = codeCV;
		this.codeTypeCont = codeTypeCont;
	}
	public Long getCodeCV() {
		return codeCV;
	}
	public void setCodeCV(Long codeCV) {
		this.codeCV = codeCV;
	}
	public Long getCodeTypeCont() {
		return codeTypeCont;
	}
	public void setCodeTypeCont(Long codeTypeCont) {
		this.codeTypeCont = codeTypeCont;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCV == null) ? 0 : codeCV.hashCode());
		result = prime * result + ((codeTypeCont == null) ? 0 : codeTypeCont.hashCode());
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
		CV_TC_ID other = (CV_TC_ID) obj;
		if (codeCV == null) {
			if (other.codeCV != null)
				return false;
		} else if (!codeCV.equals(other.codeCV))
			return false;
		if (codeTypeCont == null) {
			if (other.codeTypeCont != null)
				return false;
		} else if (!codeTypeCont.equals(other.codeTypeCont))
			return false;
		return true;
	}
	
}
