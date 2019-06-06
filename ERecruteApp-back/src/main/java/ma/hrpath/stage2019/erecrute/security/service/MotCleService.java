package ma.hrpath.stage2019.erecrute.security.service;

import java.util.List;

import ma.hrpath.stage2019.erecrute.model.MotCles;
import ma.hrpath.stage2019.erecrute.model.CategorieMotcle;

public interface MotCleService {

	public MotCles saveMotCles(MotCles MotCles) ;
	public void deleteMotCles(long MotCles);
	public boolean findMotClesById(long MotCles);
	public MotCles findMotClesByNAme(String name);
	public List<MotCles> retreiveMotCles();
	public List<String> retreiveMotClesName();
	
	public CategorieMotcle saveCategorieMotcle(CategorieMotcle CategorieMotcle) ;
	public void deleteCategorieMotcle(long CategorieMotcle);
	public boolean findCategorieMotcleById(long CategorieMotcle);
	public CategorieMotcle findCategorieMotcleByNAme(String name);
	public List<CategorieMotcle> retreiveCategorieMotcle();
	public List<String> retreiveCategorieMotcleName();
}
