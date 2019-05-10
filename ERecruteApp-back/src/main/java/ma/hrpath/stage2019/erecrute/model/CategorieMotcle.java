package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CategorieMotcle implements Serializable{
	@Id @GeneratedValue
	private Long codeCatMotCle;
	private String libelleCatMotCle;

	public CategorieMotcle() {
		super();
	}

	public CategorieMotcle(Long codeCatMotCle, String libelleCatMotCle) {
		super();
		this.codeCatMotCle = codeCatMotCle;
		this.libelleCatMotCle = libelleCatMotCle;
	}

	public Long getCodeCatMotCle() {
		return codeCatMotCle;
	}

	public void setCodeCatMotCle(Long codeCatMotCle) {
		this.codeCatMotCle = codeCatMotCle;
	}

	public String getLibelleCatMotCle() {
		return libelleCatMotCle;
	}

	public void setLibelleCatMotCle(String libelleCatMotCle) {
		this.libelleCatMotCle = libelleCatMotCle;
	}

	@Override
	public String toString() {
		return "CategorieMotcle [codeCatMotCle=" + codeCatMotCle + ", libelleCatMotCle=" + libelleCatMotCle + "]";
	}

	public void finalize() throws Throwable {

	}

}