package ma.hrpath.stage2019.erecrute.security.service;

import java.util.List;

import ma.hrpath.stage2019.erecrute.model.Experience;
import ma.hrpath.stage2019.erecrute.model.Poste;

public interface PosteService {

	public Poste savePoste(Poste Poste) ;
	public void deletePoste(long Poste);
	public Poste findPosteById(long Poste);
	public List<Poste> retreivePoste();
	public Experience saveExperience(Experience Experience) ;
	public void deleteExperience(long Experience);
	public boolean findExperienceById(long Experience);
	public List<Experience> retreiveExperience();
	public Poste updatePoste(Poste Poste);
	public Poste findPosteByMaxId();
	public List<Experience> retreiveExperiencesPoste(Long id);


}
