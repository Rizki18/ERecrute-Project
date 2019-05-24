package ma.hrpath.stage2019.erecrute.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.CV_COM;
import ma.hrpath.stage2019.erecrute.model.CV_LAN;
import ma.hrpath.stage2019.erecrute.model.CV_SF;
import ma.hrpath.stage2019.erecrute.model.CV_TC;
import ma.hrpath.stage2019.erecrute.model.CV_SA;
import ma.hrpath.stage2019.erecrute.model.Profil;
import ma.hrpath.stage2019.erecrute.model.Competence;
import ma.hrpath.stage2019.erecrute.model.SecteurActivite;
import ma.hrpath.stage2019.erecrute.repository.CvRepository;
import ma.hrpath.stage2019.erecrute.repository.ProfilRepository;

@Service
@Transactional
public class CVThequeServiceImpl implements CVThequeService{

	@Autowired
	private CvRepository cvRepository;
	@Autowired
	private ProfilService profilService;
	
	@Override
	public CV saveCV(CV cv) {
		cv.setModele("default");
		System.out.println(cv);
		return cvRepository.save(cv);
	}

	@Override
	public List<CV> retreiveCVs() {
		// TODO Auto-generated method stub
		return cvRepository.findAll();
	}
	
	@Override
	public CV retreiveCvById(Long id) {
		// TODO Auto-generated method stub
		return cvRepository.findById(id).orElse(null);
	}

	@Override
	public List<CV> retreiveCVsProfil(Long id) {
		//Profil p = profilService.findProfilById(id);
		return cvRepository.findByProfil(id);
	}

	@Override
	public void addcom(Long id, Set<CV_COM> competences) {
		CV cv = cvRepository.findBycodeCV(id);
		Set<CV_COM> competence = new HashSet<>();
		competences.forEach(comp -> {
				competence.add(comp);
		});
		cv.setM_competences(competence);
	}

	@Override
	public void addlangues(Long id, Set<CV_LAN> langues) {
		CV cv = cvRepository.findBycodeCV(id);
		Set<CV_LAN> langue = new HashSet<>();
		langues.forEach(comp -> {
				langue.add(comp);
		});
		cv.setM_langues(langue);
	}
	
	@Override
	public void addsituationFamiliale(Long id, Set<CV_SF> situationFamiliales) {
		CV cv = cvRepository.findBycodeCV(id);
		Set<CV_SF> situationFamiliale = new HashSet<>();
		situationFamiliales.forEach(comp -> {
			situationFamiliale.add(comp);
		});
		cv.setM_situationFamiliales(situationFamiliale);
	}
	
	@Override
	public void addsecteurActivite(Long id, Set<CV_SA> secteurActivites) {
		CV cv = cvRepository.findBycodeCV(id);
		Set<CV_SA> secteurActivite = new HashSet<>();
		secteurActivites.forEach(comp -> {
			secteurActivite.add(comp);
		});
		cv.setM_secteurActivites(secteurActivite);
	}
	
	@Override
	public void addtypeContract(Long id, Set<CV_TC> typeContracts) {
		CV cv = cvRepository.findBycodeCV(id);
		Set<CV_TC> typeContract = new HashSet<>();
		typeContracts.forEach(comp -> {
			typeContract.add(comp);
		});
		cv.setM_typeContrat(typeContract);
	}
}
