package ma.hrpath.stage2019.erecrute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.hrpath.stage2019.erecrute.model.Poste;


public interface PosteRepository extends JpaRepository<Poste,Long> {
	Poste findBycodePost(long codePost);
	@Query("from Poste as p where codePost in ( select MAX(codePost)  FROM Poste) ")
	Poste MaxID();
	
}
