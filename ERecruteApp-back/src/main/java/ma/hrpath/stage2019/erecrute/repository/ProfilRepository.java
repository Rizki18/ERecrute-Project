package ma.hrpath.stage2019.erecrute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.hrpath.stage2019.erecrute.model.Profil;
import ma.hrpath.stage2019.erecrute.model.User;

public interface ProfilRepository extends JpaRepository<Profil,Long> {
	Profil findBycin(String cin);
	@Query("from Profil as p where codeProfil in ( select MAX(codeProfil)  FROM Profil) ")
	Profil MaxID();
	
}
