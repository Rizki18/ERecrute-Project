package ma.hrpath.stage2019.erecrute.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.Profil;
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

}
