package ma.hrpath.stage2019.erecrute.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ma.hrpath.stage2019.erecrute.repository.ProfilRepository;
import ma.hrpath.stage2019.erecrute.repository.FormationRepository;
import ma.hrpath.stage2019.erecrute.model.Formation;
import ma.hrpath.stage2019.erecrute.model.Profil;
@Service
@Transactional
public class ProfilServiceImpl implements ProfilService {

	@Autowired
	private ProfilRepository ProfilRepository;
	@Autowired
	private FormationRepository FormationRepository;
	
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

}
