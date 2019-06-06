package ma.hrpath.stage2019.erecrute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hrpath.stage2019.erecrute.model.MotCles;

public interface MotclesRepository extends JpaRepository<MotCles,Long> {

	MotCles findBylibelleMotCle(String motcles);
}
