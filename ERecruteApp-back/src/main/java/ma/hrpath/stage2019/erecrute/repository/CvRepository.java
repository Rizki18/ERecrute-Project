package ma.hrpath.stage2019.erecrute.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.CV_COMP;
import ma.hrpath.stage2019.erecrute.model.Competence;
import ma.hrpath.stage2019.erecrute.model.Profil;

public interface CvRepository extends JpaRepository<CV, Long> {

	@Query("select cv from CV cv where cv.Profil.codeProfil=:x")
	List<CV> findByProfil(@Param("x")Long idProfil);
	CV findBycodeCV(Long id);
	@Query("from CV as cv where codeCV in ( select MAX(codeCV)  FROM CV) ")
	CV MaxID();
}
