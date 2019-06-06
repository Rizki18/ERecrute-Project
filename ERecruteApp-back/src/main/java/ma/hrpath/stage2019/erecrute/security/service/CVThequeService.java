package ma.hrpath.stage2019.erecrute.security.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import ma.hrpath.stage2019.erecrute.message.request.CompetenceForm;
import ma.hrpath.stage2019.erecrute.message.request.CvForm;
import ma.hrpath.stage2019.erecrute.message.request.ExperienceForm;
import ma.hrpath.stage2019.erecrute.message.request.LangueForm;
import ma.hrpath.stage2019.erecrute.message.request.SaForm;
import ma.hrpath.stage2019.erecrute.message.request.SfForm;
import ma.hrpath.stage2019.erecrute.message.request.TcForm;
import ma.hrpath.stage2019.erecrute.message.request.TpForm;
import ma.hrpath.stage2019.erecrute.message.response.CV_COMP_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_LNG_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_SA_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_SF_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_TC_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_TP_RES;
import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.CV_COMP;
import ma.hrpath.stage2019.erecrute.model.Competence;
import ma.hrpath.stage2019.erecrute.model.Experience;

public interface CVThequeService {
	public CV saveCV(CvForm cv);

	public List<CV> retreiveCVs();

	CV retreiveCvById(Long id);

	public List<CV> retreiveCVsProfil(Long id);
	
	public List<Experience> retreiveExpsCV(Long id);

	public Set<Experience> retreiveExpsProfil(Long id);

	public void saveExperience(ExperienceForm f);

	public void addExperienceToCV(String idCV,Set<String> exp);

	public List<CV_COMP_RES> retreiveCompsCV(Long id);
	public void addCompetenceToCV(CompetenceForm f);
	public void addCompetencesToCV(String idCV,Set<String> exp);

	public void addLanguesToCV(String cv, String langue);
	public void addLangueToCV(LangueForm f);
	public List<CV_LNG_RES> retreiveLanguesCV(Long id);

	public void addSAsToCV(String cv, String sa);
	public void addSaToCV(SaForm f);
	public List<CV_SA_RES> retreiveSAsCV(Long id);

	public void addSFsToCV(String cv, String sf);
	public void addSfToCV(SfForm f);
	public List<CV_SF_RES> retreiveSFsCV(Long id);

	public void addTPsToCV(String cv, String tp);
	public void addTpToCV(TpForm f);
	public List<CV_TP_RES> retreiveTPsCV(Long id);

	public void addTCsToCV(String cv, String tc);
	public void addTcToCV(TcForm f);
	public List<CV_TC_RES> retreiveTCsCV(Long id);
	
}
