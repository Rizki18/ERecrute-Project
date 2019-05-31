package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CV_COMP implements Serializable{

		@Id
	    @ManyToOne
	    @JoinColumn
	    @JsonIgnore
	    private CV cv;

	    @Id
	    @ManyToOne
	    @JoinColumn
	    @JsonIgnore
	    private Competence comp;
	    
	    private String detail;
		private Double niveau;

		public CV_COMP() {
			super();
		}


		public CV_COMP(CV cv, Competence comp, String detail, Double niveau) {
			super();
			this.cv = cv;
			this.comp = comp;
			this.detail = detail;
			this.niveau = niveau;
		}


		public CV getCv() {
			return cv;
		}

		public void setCv(CV cv) {
			this.cv = cv;
		}

		public Competence getComp() {
			return comp;
		}

		public void setComp(Competence comp) {
			this.comp = comp;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		public Double getNiveau() {
			return niveau;
		}

		public void setNiveau(Double niveau) {
			this.niveau = niveau;
		}

		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((comp == null) ? 0 : comp.hashCode());
			result = prime * result + ((cv == null) ? 0 : cv.hashCode());
			result = prime * result + ((detail == null) ? 0 : detail.hashCode());
			result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
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
			CV_COMP other = (CV_COMP) obj;
			if (comp == null) {
				if (other.comp != null)
					return false;
			} else if (!comp.equals(other.comp))
				return false;
			if (cv == null) {
				if (other.cv != null)
					return false;
			} else if (!cv.equals(other.cv))
				return false;
			if (detail == null) {
				if (other.detail != null)
					return false;
			} else if (!detail.equals(other.detail))
				return false;
			if (niveau == null) {
				if (other.niveau != null)
					return false;
			} else if (!niveau.equals(other.niveau))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "CV_COMP [cv=" + cv + ", comp=" + comp + ", detail=" + detail + ", niveau=" + niveau + "]";
		}

}
