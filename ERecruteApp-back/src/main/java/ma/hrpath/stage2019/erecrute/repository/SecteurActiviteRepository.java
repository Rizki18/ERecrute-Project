package ma.hrpath.stage2019.erecrute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hrpath.stage2019.erecrute.model.SecteurActivite;

public interface SecteurActiviteRepository extends JpaRepository<SecteurActivite,Long> {
	SecteurActivite findBylibelleSecteur(String name);
}
