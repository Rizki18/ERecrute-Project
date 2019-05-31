package ma.hrpath.stage2019.erecrute.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.hrpath.stage2019.erecrute.model.Profil;
import ma.hrpath.stage2019.erecrute.repository.ProfilRepository;

@Component
public class DBWriter  implements ItemWriter<Profil>{
	
	 @Autowired
	    private ProfilRepository profilRespository;

	@Override
	public void write(List<? extends Profil> profil) throws Exception {
		 System.out.println("Data Saved for Profil: " + profil); 
		 
		 profilRespository.saveAll(profil);
		
	}

}
