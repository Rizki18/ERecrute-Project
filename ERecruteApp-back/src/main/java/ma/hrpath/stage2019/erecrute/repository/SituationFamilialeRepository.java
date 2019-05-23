package ma.hrpath.stage2019.erecrute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hrpath.stage2019.erecrute.model.SituationFamiliale;

public interface SituationFamilialeRepository extends JpaRepository<SituationFamiliale,Long> {

	SituationFamiliale findBycivilite(String name);
}
