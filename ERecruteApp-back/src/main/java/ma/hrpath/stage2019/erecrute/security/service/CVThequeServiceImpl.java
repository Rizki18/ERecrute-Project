package ma.hrpath.stage2019.erecrute.security.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.Experience;
import ma.hrpath.stage2019.erecrute.model.Poste;
import ma.hrpath.stage2019.erecrute.model.Profil;
import ma.hrpath.stage2019.erecrute.model.Societe;
import ma.hrpath.stage2019.erecrute.repository.CvRepository;
import ma.hrpath.stage2019.erecrute.repository.ExperienceRepository;
import ma.hrpath.stage2019.erecrute.repository.PosteRepository;
import ma.hrpath.stage2019.erecrute.repository.ProfilRepository;
import ma.hrpath.stage2019.erecrute.repository.SocieteRepository;

@Service
@Transactional
public class CVThequeServiceImpl implements CVThequeService{

	@Autowired
	private CvRepository cvRepository;
	@Autowired
	private ProfilService profilService;
	@Autowired
	private ExperienceRepository expRepository;
	@Autowired
	private PosteRepository posteRepository;
	@Autowired
	private SocieteRepository steRepository;
	
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
	public Experience save(Date dateDebut, Date dateFin, String departement, String descriptionRole, Long idPoste,
			Long idSte) {
		
		Poste poste = posteRepository.findById(idPoste).orElse(null);
		Societe ste = steRepository.findById(idSte).orElse(null);
		Experience exp = new Experience(dateDebut,dateFin,departement,descriptionRole);
		exp.setPoste(poste);
		exp.setSociete(ste);
		
		return expRepository.save(exp);
	}

	@Override
	public void addExperienceToCV(Long idCV, Experience exp) {
		CV cv = cvRepository.findById(idCV).orElse(null);
		cv.addExp(exp);
	}

	@Override
	public List<Experience> retreiveExpsCV(Long id) {
		List<Experience> exps = new ArrayList<Experience>();
		
		CV cv = cvRepository.findById(id).orElse(null);
		
		for(Experience exp : cv.getExps())
			exps.add(exp);
			
		return exps;
	}

	@Override
	public Set<Experience> retreiveExpsProfil(Long id) {
		List<CV> cvs = this.retreiveCVsProfil(id);
		Set<Experience> exps = new HashSet<Experience>();
		for(CV cv : cvs) {
			exps.addAll(cv.getExps());
		}
		
		return exps;
	}

}
