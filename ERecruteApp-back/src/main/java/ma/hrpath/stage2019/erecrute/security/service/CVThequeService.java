package ma.hrpath.stage2019.erecrute.security.service;

import java.util.List;
import java.util.Optional;

import ma.hrpath.stage2019.erecrute.model.CV;

public interface CVThequeService {
	public CV saveCV(CV cv);

	public List<CV> retreiveCVs();

	CV retreiveCvById(Long id);

	public List<CV> retreiveCVsProfil(Long id);
}
