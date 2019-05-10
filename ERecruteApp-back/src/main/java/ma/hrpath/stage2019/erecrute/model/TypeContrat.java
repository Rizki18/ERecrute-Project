package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeContrat implements Serializable {
	@Id @GeneratedValue
	private Long codeTypeContrat;
	private String libelleContrat;

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
		return "TypeContrat [codeTypeContrat=" + codeTypeContrat + ", libelleContrat=" + libelleContrat + "]";
	}

	public void finalize() throws Throwable {

	}

}