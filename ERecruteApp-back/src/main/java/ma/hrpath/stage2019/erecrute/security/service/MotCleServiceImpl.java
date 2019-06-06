package ma.hrpath.stage2019.erecrute.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hrpath.stage2019.erecrute.model.CategorieMotcle;
import ma.hrpath.stage2019.erecrute.model.MotCles;
import ma.hrpath.stage2019.erecrute.model.MotCles;
import ma.hrpath.stage2019.erecrute.repository.CategorieMotcleRepository;
import ma.hrpath.stage2019.erecrute.repository.MotclesRepository;
@Service
@Transactional
public class MotCleServiceImpl implements MotCleService {

	@Autowired
	private MotclesRepository motclesRepository ;
	@Autowired
	private CategorieMotcleRepository categoriemotcleRepository ;

	@Override
	public MotCles saveMotCles(MotCles MotCles) {
		return motclesRepository.save(MotCles);
	}

	@Override
	public void deleteMotCles(long MotCles) {
		motclesRepository.deleteById(MotCles);
		
	}

	@Override
	public boolean findMotClesById(long MotCles) {
		if(motclesRepository.findById(MotCles)!= null)
			return true;
		return false;
	}

	@Override
	public MotCles findMotClesByNAme(String name) {
		return motclesRepository.findBylibelleMotCle(name);
	}

	@Override
	public List<MotCles> retreiveMotCles() {
		return motclesRepository.findAll();
	}

	@Override
	public List<String> retreiveMotClesName() {
		List<MotCles> comp= motclesRepository.findAll();
		List<String> l = new ArrayList();
		for(MotCles c : comp)
		{
			l.add(c.getLibelleMotCle());
		}
		return l;
	}

	@Override
	public CategorieMotcle saveCategorieMotcle(CategorieMotcle CategorieMotcle) {
		return categoriemotcleRepository.save(CategorieMotcle);
	}

	@Override
	public void deleteCategorieMotcle(long id) {
		categoriemotcleRepository.deleteById(id);
		
	}

	@Override
	public boolean findCategorieMotcleById(long id) {
		if(categoriemotcleRepository.findById(id) != null)
			return true;
		return false;
	}

	@Override
	public CategorieMotcle findCategorieMotcleByNAme(String name) {
		//return categoriemotcleRepository.findByLibelle_Mot_Cle();
		return null;
	}

	@Override
	public List<CategorieMotcle> retreiveCategorieMotcle() {
		return categoriemotcleRepository.findAll();
	}

	@Override
	public List<String> retreiveCategorieMotcleName() {
		List<CategorieMotcle> comp= categoriemotcleRepository.findAll();
		List<String> l = new ArrayList();
		for(CategorieMotcle c : comp)
		{
			l.add(c.getLibelle_Mot_Cle());
		}
		return l;

	}

}
