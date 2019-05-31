package ma.hrpath.stage2019.erecrute.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.hrpath.stage2019.erecrute.message.request.CompetenceForm;
import ma.hrpath.stage2019.erecrute.message.request.CvForm;
import ma.hrpath.stage2019.erecrute.message.request.ExperienceForm;
import ma.hrpath.stage2019.erecrute.message.request.FormationForm;
import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.CV_COMP;
import ma.hrpath.stage2019.erecrute.model.Competence;
import ma.hrpath.stage2019.erecrute.model.Experience;
import ma.hrpath.stage2019.erecrute.model.Formation;
import ma.hrpath.stage2019.erecrute.model.Poste;
import ma.hrpath.stage2019.erecrute.model.Profil;
import ma.hrpath.stage2019.erecrute.model.Societe;
import ma.hrpath.stage2019.erecrute.repository.CompetenceRepository;
import ma.hrpath.stage2019.erecrute.repository.ExperienceRepository;
import ma.hrpath.stage2019.erecrute.repository.PosteRepository;
import ma.hrpath.stage2019.erecrute.repository.SocieteRepository;
import ma.hrpath.stage2019.erecrute.security.service.CVThequeService;
import ma.hrpath.stage2019.erecrute.security.service.ProfilService;

@CrossOrigin(origins = "*")
@RestController
public class CVThequeRestAPIs {
	@Autowired
	private CVThequeService cvThequeService;
	@Autowired
	private PosteRepository posteRepository;
	@Autowired
	private SocieteRepository steRepository;
	@Autowired
	private CompetenceRepository compRepository;
	@Autowired
	private ProfilService profilService;
	@Autowired
	private ExperienceRepository expRepository;
	
	@RequestMapping(value="/admin/saveExperienceCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void saveExperienceCV(@RequestBody ExperienceForm f) {
		CV cv = cvThequeService.retreiveCvById(Long.valueOf(f.getCv()));
		Set<Experience> exps;
		
		if(f.getDepartement()!="" && f.getDescriptionRole()!="") {
			Experience exp = new Experience(f.getDateDebut(),f.getDateFin(),f.getDepartement(),f.getDescriptionRole());
			exp.setPoste(posteRepository.findById(Long.valueOf(f.getPoste())).orElse(null));
			exp.setSociete(steRepository.findById(Long.valueOf(f.getSociete())).orElse(null));
			expRepository.save(exp);
			System.out.println(exp);
			
			
			exps = cv.getExps();

			exps.add(exp);
		}
		else {
			exps = new HashSet<Experience>();
			
			for(String e : f.getExp()) {
				exps.add(expRepository.findByDescriptionRole(e));
			}
		}
		
		cv.setExps(exps);
		
		cvThequeService.saveCV(cv);
		
	}
	
	@RequestMapping(value="/admin/saveCompetenceCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void saveCompetenceCV(@RequestBody CompetenceForm f) {
		System.out.println(f.getCompetence());
		System.out.println(f.getCv());
		System.out.println(f.getDetails());
		System.out.println(f.getNiveau());
		
		CV cv = cvThequeService.retreiveCvById(Long.valueOf(f.getCv()));
		
		CV newCV = cv;
		
		Competence comp = compRepository.findById(Long.valueOf(f.getCompetence())).orElse(null);
		CV_COMP compCV = new CV_COMP(cv,comp,f.getDetails(),Double.valueOf(f.getNiveau()));
		System.out.println(compCV);
		/*
		Set<CV_COMP> compsCV = new HashSet<CV_COMP>();
		compsCV.add(compCV);
		System.out.println(compsCV);
		*/
		
		newCV.getM_competences().add(compCV); 
		
		cvThequeService.saveCV(newCV);
		
	}
	
	@RequestMapping(value="/admin/saveCv",method = RequestMethod.POST)
	public CV saveCv(@RequestBody CvForm cv) {
		System.out.println(cv);
		CV newCV = new CV(cv.getModele(),cv.getNomCV(),cv.getPosteDesire());
		Profil profil = profilService.findProfilById(Long.valueOf(cv.getProfil()));
		newCV.setProfil(profil);
		System.out.println(newCV);
		return cvThequeService.saveCV(newCV);
	}
	
	@RequestMapping(value="/profil/{id}/cvs")
	public List<CV> listCVsProfil(@PathVariable("id") Long id){
		return cvThequeService.retreiveCVsProfil(id);
	}
	
	@RequestMapping(value="/cv/{id}/profil")
	public Profil getProfilCV(@PathVariable("id") Long id){
		CV cv = cvThequeService.retreiveCvById(id);
		return cv.getProfil();
	}
	
	@RequestMapping(value="/cv/{id}")
	public CV getCV(@PathVariable("id") Long id){
		return cvThequeService.retreiveCvById(id);
	}
	
	@RequestMapping(value="/cv/{id}/experiences")
	public List<Experience> listExpsCV(@PathVariable("id") Long id){
		return cvThequeService.retreiveExpsCV(id);
	}
	
	@RequestMapping(value="/cv/{id}/competences")
	public List<CV_COMP> listCompsCV(@PathVariable("id") Long id){
		return cvThequeService.retreiveCompsCV(id);
	}
	
	@RequestMapping(value="/societes")
	public List<Societe> listSocietes(){
		return steRepository.findAll();
	}
	
	@RequestMapping(value="/postes")
	public List<Poste> listPostes(){
		return posteRepository.findAll();
	}
	
	@RequestMapping(value="/profil/{id}/experiences")
	public Set<Experience> listExpsProfil(@PathVariable("id") Long id){
		return cvThequeService.retreiveExpsProfil(id);
	}
	
	
	/*
	@RequestMapping(value="/admin/deleteCV/{id}",method = RequestMethod.DELETE)
	public void deleteCV(@PathVariable("id") Long id) {
		profilService.deleteCV(id);
	}*/
}
