package ma.hrpath.stage2019.erecrute.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ma.hrpath.stage2019.erecrute.repository.ProfilRepository;
import ma.hrpath.stage2019.erecrute.repository.FormationRepository;
import ma.hrpath.stage2019.erecrute.repository.ExperienceRepository;
import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.Experience;
import ma.hrpath.stage2019.erecrute.model.Formation;
import ma.hrpath.stage2019.erecrute.model.Profil;
@Service
@Transactional
public class ProfilServiceImpl implements ProfilService {

	@Autowired
	private ProfilRepository ProfilRepository;
	@Autowired
	private FormationRepository FormationRepository;
	@Autowired
	private ExperienceRepository ExperienceRepository;
	
	@Override
	public Profil saveProfil(Profil Profil) {
		return ProfilRepository.save(Profil);
	}
	
	@Override
	public Profil updateProfil(Profil Profil) {
		return ProfilRepository.save(Profil);
	}

	@Override
	public void deleteProfil(long id) {
		ProfilRepository.deleteById(id);
		
	}

	@Override
	public Profil findProfilById(long Profil) {
		Profil profil = ProfilRepository.findById(Profil).orElse(null); ;
		return profil;
	}
	@Override
	public Profil findProfilByMaxId() {
		return ProfilRepository.MaxID();
	}
	@Override
	public boolean findProfilByCIN(String Profil) {
		if(ProfilRepository.findBycin (Profil) != null)
			return true;
		return false;
	}

	@Override
	public List<Profil> retreiveProfil() {
		return ProfilRepository.findAll();
	}

	@Override
	public Formation saveFormation(Formation Formation) {
		return FormationRepository.save(Formation);
	}
	@Override
	public void deleteFormation(long Formation) {
		FormationRepository.deleteById(Formation);
		
	}

	@Override
	public boolean findFormationById(long Formation) {
		if(FormationRepository.findById(Formation) != null)
			return true;
		return false;
	}

	@Override
	public List<Formation> retreiveFormation() {
		return FormationRepository.findAll();
	}

	@Override
	public List<Formation> retreiveFormationsProfil(Long id) {
		// TODO Auto-generated method stub
		return FormationRepository.findByProfil(id);
	}
	public void addExperienceToCV(String id,Set<String> exp) {

		Profil profil = ProfilRepository.findBycodeProfil(Long.valueOf(id));
		Set<Experience> exps;
		
		exps = new HashSet<Experience>();
		
		for(String e : exp) {
			exps.add(ExperienceRepository.findById(Long.valueOf(e)).orElse(null));
		}
		
		profil.setM_Experience(exps);
		ProfilRepository.save(profil);
	}

	@Override
	public Experience saveExperience(Experience Experience) {
		return ExperienceRepository.save(Experience);
	}

	@Override
	public void deleteExperience(long id) {
		ExperienceRepository.deleteById(id);
		
	}

	@Override
	public boolean findExperienceById(long id) {
		if(ExperienceRepository.findById(id)!= null)
			return true;
		return false;
	}

	@Override
	public List<Experience> retreiveExperience() {
		return ExperienceRepository.findAll();
	}

	@Override
	public List<Experience> retreiveExperiencesProfil(Long id) {
		return ExperienceRepository.findByProfil(id);
	}

}
