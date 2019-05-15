package ma.hrpath.stage2019.erecrute.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.repository.CvRepository;

@Service
@Transactional
public class CVThequeServiceImpl implements CVThequeService{

	@Autowired
	private CvRepository cvRepository;
	
	@Override
	public CV saveCV(CV cv) {
		cv.setModele("default");
		System.out.println(cv);
		return cvRepository.save(cv);
	}

}
