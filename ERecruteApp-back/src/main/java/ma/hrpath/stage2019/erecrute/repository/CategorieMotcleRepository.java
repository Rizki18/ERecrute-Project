package ma.hrpath.stage2019.erecrute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hrpath.stage2019.erecrute.model.CategorieMotcle;

public interface CategorieMotcleRepository extends JpaRepository<CategorieMotcle,Long> {
	
	//CategorieMotcle findBylibelle_Mot_Cle(String nom);

}
