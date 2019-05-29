package ma.hrpath.stage2019.erecrute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.hrpath.stage2019.erecrute.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
	public Experience findByDescriptionRole(String s);
}