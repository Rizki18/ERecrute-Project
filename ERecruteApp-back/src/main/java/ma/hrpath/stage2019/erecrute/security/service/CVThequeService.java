package ma.hrpath.stage2019.erecrute.security.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.CV_COM;
import ma.hrpath.stage2019.erecrute.model.CV_LAN;
import ma.hrpath.stage2019.erecrute.model.CV_SA;
import ma.hrpath.stage2019.erecrute.model.CV_SF;
import ma.hrpath.stage2019.erecrute.model.CV_TC;

public interface CVThequeService {
	public CV saveCV(CV cv);

	public List<CV> retreiveCVs();

	CV retreiveCvById(Long id);

	public List<CV> retreiveCVsProfil(Long id);

	void addcom(Long id, Set<CV_COM> competences);

	void addlangues(Long id, Set<CV_LAN> langues);

	void addsituationFamiliale(Long id, Set<CV_SF> situationFamiliales);

	//void addsecteurActivite(Long id, Set<CV_SA> secteurActivite);
	//oid addcom(Long id, Set<CV_COM> competences);

	void addsecteurActivite(Long id, Set<CV_SA> secteurActivite);

	void addtypeContract(Long id, Set<CV_TC> typeContracts);
}
