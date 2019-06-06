package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CV_COMP_ID implements Serializable {
	@Column(name = "code_cv", nullable = false)
	private Long codeCV;
	@Column(name = "code_comp", nullable = false)
	private Long codeCompetance;
	
	public CV_COMP_ID() {
		super();
	}

	public CV_COMP_ID(Long codeCV, Long codeCompetance) {
		super();
		this.codeCV = codeCV;
		this.codeCompetance = codeCompetance;
	}
	
	public Long getCodeCV() {
		return codeCV;
	}


	public void setCodeCV(Long codeCV) {
		this.codeCV = codeCV;
	}
	public Long getCodeCompetance() {
		return codeCompetance;
	}
	public void setCodeCompetance(Long codeCompetance) {
		this.codeCompetance = codeCompetance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCV == null) ? 0 : codeCV.hashCode());
		result = prime * result + ((codeCompetance == null) ? 0 : codeCompetance.hashCode());
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
		CV_COMP_ID other = (CV_COMP_ID) obj;
		if (codeCV == null) {
			if (other.codeCV != null)
				return false;
		} else if (!codeCV.equals(other.codeCV))
			return false;
		if (codeCompetance == null) {
			if (other.codeCompetance != null)
				return false;
		} else if (!codeCompetance.equals(other.codeCompetance))
			return false;
		return true;
	}
	
	

}
