package ma.hrpath.stage2019.erecrute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hrpath.stage2019.erecrute.model.TypeContrat;

public interface TypeContratRepository extends JpaRepository<TypeContrat,Long>{
	TypeContrat findBylibelleContrat(String name);
}
