package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CV_LNG_ID implements Serializable {
	@Column(name = "code_cv", nullable = false)
	private Long codeCV;
	@Column(name = "code_lng", nullable = false)
	private Long codeLangue;
	public CV_LNG_ID() {
		super();
	}
	public CV_LNG_ID(Long codeCV, Long codeLangue) {
		super();
		this.codeCV = codeCV;
		this.codeLangue = codeLangue;
	}
	public Long getCodeCV() {
		return codeCV;
	}
	public void setCodeCV(Long codeCV) {
		this.codeCV = codeCV;
	}
	public Long getCodeLangue() {
		return codeLangue;
	}
	public void setCodeLangue(Long codeLangue) {
		this.codeLangue = codeLangue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCV == null) ? 0 : codeCV.hashCode());
		result = prime * result + ((codeLangue == null) ? 0 : codeLangue.hashCode());
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
		CV_LNG_ID other = (CV_LNG_ID) obj;
		if (codeCV == null) {
			if (other.codeCV != null)
				return false;
		} else if (!codeCV.equals(other.codeCV))
			return false;
		if (codeLangue == null) {
			if (other.codeLangue != null)
				return false;
		} else if (!codeLangue.equals(other.codeLangue))
			return false;
		return true;
	}
	
}
