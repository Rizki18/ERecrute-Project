package ma.hrpath.stage2019.erecrute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.hrpath.stage2019.erecrute.model.Experience;
import ma.hrpath.stage2019.erecrute.model.Formation;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
	public Experience findByDescriptionRole(String s);
	@Query("select f from Experience f where f.Poste.codePost=:x")
	List<Experience> findByPoste(@Param("x")Long idPost);
	@Query("select f from Experience f where f.Profil.codeProfil=:x")
	List<Experience> findByProfil(@Param("x")Long idProfil);

}