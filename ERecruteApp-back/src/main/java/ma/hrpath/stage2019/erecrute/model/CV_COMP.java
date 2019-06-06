package ma.hrpath.stage2019.erecrute.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CV_COMP implements Serializable{
	
	@EmbeddedId
	private CV_COMP_ID id_cvComp;

		
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JsonIgnore
	    @MapsId("codeCV")
	    private CV cv;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JsonIgnore
	    @MapsId("codeCompetance")
	    private Competence comp;
	    
	    private String detail;
		private Double niveau;

		public CV_COMP() {
			super();
		}


		public CV_COMP(CV cv, Competence comp, String detail, Double niveau) {
			super();
			this.id_cvComp = new CV_COMP_ID(cv.getCodeCV(),comp.getCodeCompetance());
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
		public String toString() {
			return "detail=" + detail + ", niveau=" + niveau + "]";
		}

}
