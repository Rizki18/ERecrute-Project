package ma.hrpath.stage2019.erecrute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.Formation;

public interface FormationRepository extends JpaRepository<Formation,Long> {
	@Query("select f from Formation f where f.Profil.codeProfil=:x")
	List<Formation> findByProfil(@Param("x")Long idProfil);
}
