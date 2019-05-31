package ma.hrpath.stage2019.erecrute.security.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hrpath.stage2019.erecrute.model.Experience;
import ma.hrpath.stage2019.erecrute.model.Poste;
import ma.hrpath.stage2019.erecrute.repository.ExperienceRepository;
import ma.hrpath.stage2019.erecrute.repository.PosteRepository;

@Service
@Transactional
public class PosteServiceImpl implements PosteService{
	@Autowired
	private PosteRepository posteRepository;
	@Autowired
	private ExperienceRepository experienceRepository;
	
	@Override
	public Poste savePoste(Poste Poste){
		return posteRepository.save(Poste);
	}
	
	@Override
	public Poste updatePoste(Poste Poste) {
		return posteRepository.save(Poste);
	}

	@Override
	public void deletePoste(long id) {
		posteRepository.deleteById(id);
		
	}

	@Override
	public Poste findPosteById(long id) {
		Poste poste = posteRepository.findById(id).orElse(null); ;
		return poste;
	}
	@Override
	public Poste findPosteByMaxId() {
		return posteRepository.MaxID();
	}
	@Override
	public List<Poste> retreivePoste() {
		return posteRepository.findAll();
	}

	@Override
	public Experience saveExperience(Experience Experience) {
		return experienceRepository.save(Experience);
	}
	@Override
	public void deleteExperience(long Experience) {
		experienceRepository.deleteById(Experience);
		
	}

	@Override
	public boolean findExperienceById(long Experience) {
		if(experienceRepository.findById(Experience) != null)
			return true;
		return false;
	}

	@Override
	public List<Experience> retreiveExperience() {
		return experienceRepository.findAll();
	}

	@Override
	public List<Experience> retreiveExperiencesPoste(Long id) {
		// TODO Auto-generated method stub
		return experienceRepository.findByPoste(id);
	}

}
