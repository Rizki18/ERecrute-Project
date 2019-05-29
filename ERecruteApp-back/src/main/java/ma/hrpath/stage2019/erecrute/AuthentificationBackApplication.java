package ma.hrpath.stage2019.erecrute;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.CV_SA;
import ma.hrpath.stage2019.erecrute.model.Experience;
import ma.hrpath.stage2019.erecrute.model.Poste;
import ma.hrpath.stage2019.erecrute.model.Profil;
import ma.hrpath.stage2019.erecrute.model.Role;
import ma.hrpath.stage2019.erecrute.model.SecteurActivite;
import ma.hrpath.stage2019.erecrute.model.Societe;
import ma.hrpath.stage2019.erecrute.repository.CvRepository;
import ma.hrpath.stage2019.erecrute.repository.ExperienceRepository;
import ma.hrpath.stage2019.erecrute.repository.PosteRepository;
import ma.hrpath.stage2019.erecrute.repository.ProfilRepository;
import ma.hrpath.stage2019.erecrute.repository.SecteurActiviteRepository;
import ma.hrpath.stage2019.erecrute.repository.SocieteRepository;

@SpringBootApplication(scanBasePackages = "ma")
@EntityScan("ma.*")
@EnableJpaRepositories("ma.*")
public class AuthentificationBackApplication{
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AuthentificationBackApplication.class, args);
/*
		//CV_SA
		SecteurActiviteRepository saRepository = ctx.getBean(SecteurActiviteRepository.class);
		CvRepository cvRepository = ctx.getBean(CvRepository.class);
		ProfilRepository profilRepository = ctx.getBean(ProfilRepository.class);

        SecteurActivite sa1 = new SecteurActivite("Comptabilite");
        SecteurActivite sa2 = new SecteurActivite("developpment");
		saRepository.saveAll(Arrays.asList(sa1,sa2));
		
		CV cv = new CV("modele","nomCV","posteCV");
		
		Profil p = profilRepository.findById(Long.valueOf("1")).orElse(null);
		cv.setProfil(p);
		
		cv.setSecteurActivites(new CV_SA(sa1,new Date(),new Date()),new CV_SA(sa2,new Date(),new Date())); 
		
		 // cv_exps
		PosteRepository posteRepository = ctx.getBean(PosteRepository.class);
		SocieteRepository societeRepository = ctx.getBean(SocieteRepository.class);
		ExperienceRepository expRepository = ctx.getBean(ExperienceRepository.class);
		
		Poste poste = new Poste("developpement des application web","developpeur");
		posteRepository.save(poste);
		
		Societe ste = new Societe("HRPATH");
		societeRepository.save(ste);
		
		Experience exp = new Experience(new Date(),new Date(),"marketing","consultant");
		exp.setPoste(poste);
		exp.setSociete(ste);
		expRepository.save(exp);
		
		Set<Experience> exps = new HashSet<Experience>();
		exps.add(exp);
		cv.setExps(exps);
		
		cvRepository.save(cv);
		
		System.out.println(cv.getM_secteurActivites());
		
		System.out.println(cv.getExps());
		
	*/	
				
	}

}
