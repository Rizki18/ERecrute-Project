package ma.hrpath.stage2019.erecrute.security.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.Experience;

public interface CVThequeService {
	public CV saveCV(CV cv);

	public List<CV> retreiveCVs();

	CV retreiveCvById(Long id);

	public List<CV> retreiveCVsProfil(Long id);
	
	public Experience save(Date dateDebut, Date dateFin, String departement, String descriptionRole, Long idPoste, Long idSte);
	
	public void addExperienceToCV(Long idCV,Experience exp);

	public List<Experience> retreiveExpsCV(Long id);

	public Set<Experience> retreiveExpsProfil(Long id);
}
