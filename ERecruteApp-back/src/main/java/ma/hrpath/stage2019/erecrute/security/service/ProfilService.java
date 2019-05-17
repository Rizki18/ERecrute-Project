package ma.hrpath.stage2019.erecrute.security.service;

import java.util.List;
import java.util.Optional;

import ma.hrpath.stage2019.erecrute.model.Profil;
import ma.hrpath.stage2019.erecrute.model.Formation;

public interface ProfilService {

	public Profil saveProfil(Profil Profil) ;
	public void deleteProfil(long Profil);
	public Optional<Profil> findProfilById(long Profil);
	public boolean findProfilByCIN(String Profil);
	public List<Profil> retreiveProfil();
	public Formation saveFormation(Formation Formation) ;
	public void deleteFormation(long Formation);
	public boolean findFormationById(long Formation);
	public List<Formation> retreiveFormation();
	public Profil updateProfil(Profil Profil);
	public Profil findProfilByMaxId();
}
