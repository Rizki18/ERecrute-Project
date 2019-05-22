package ma.hrpath.stage2019.erecrute.security.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<CV> retreiveCVs() {
		// TODO Auto-generated method stub
		return cvRepository.findAll();
	}
	
	@Override
	public Optional<CV> retreiveCvById(Long id) {
		// TODO Auto-generated method stub
		return cvRepository.findById(id);
	}

}
