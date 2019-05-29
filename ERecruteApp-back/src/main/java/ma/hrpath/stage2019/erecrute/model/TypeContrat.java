package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypeContrat implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeTypeContrat;
	private String libelleContrat;
	
	@OneToMany(mappedBy = "tc", cascade = CascadeType.ALL)
	private Set<CV_TC> m_cvs;

	public TypeContrat() {
		super();
	}

	public TypeContrat(Long codeTypeContrat, String libelleContrat) {
		super();
		this.codeTypeContrat = codeTypeContrat;
		this.libelleContrat = libelleContrat;
	}

	public Long getCodeTypeContrat() {
		return codeTypeContrat;
	}

	public void setCodeTypeContrat(Long codeTypeContrat) {
		this.codeTypeContrat = codeTypeContrat;
	}

	public String getLibelleContrat() {
		return libelleContrat;
	}

	public void setLibelleContrat(String libelleContrat) {
		this.libelleContrat = libelleContrat;
	}

	@Override
	public String toString() {
		return "TypeContrat [codeTypeContrat=" + codeTypeContrat + ", libelleContrat=" + libelleContrat + ", m_cvs="
				+ m_cvs + "]";
	}

	public void finalize() throws Throwable {

	}

}