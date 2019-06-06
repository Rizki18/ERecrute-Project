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
import ma.hrpath.stage2019.erecrute.message.request.LangueForm;
import ma.hrpath.stage2019.erecrute.message.request.SaForm;
import ma.hrpath.stage2019.erecrute.message.request.SfForm;
import ma.hrpath.stage2019.erecrute.message.request.TcForm;
import ma.hrpath.stage2019.erecrute.message.request.TpForm;
import ma.hrpath.stage2019.erecrute.message.response.CV_COMP_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_LNG_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_SA_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_SF_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_TC_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_TP_RES;
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
	
	@RequestMapping(value="/admin/saveExperienceCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void saveExperienceCV(@RequestBody ExperienceForm f) {
		cvThequeService.saveExperience(f);
	}
	
	@RequestMapping(value="/admin/addExperienceToCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void addExperienceToCV(@RequestBody ExperienceForm f) {
		cvThequeService.addExperienceToCV(f.getCv(),f.getExp());
	}
	
	@RequestMapping(value="/admin/saveCv",method = RequestMethod.POST)
	public CV saveCv(@RequestBody CvForm cv) {
		return cvThequeService.saveCV(cv);
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
	
	@RequestMapping(value="/admin/addCompetencesToCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void addCompetencesToCV(@RequestBody CompetenceForm f) {
		cvThequeService.addCompetencesToCV(f.getCv(),f.getComp());
	}
	
	@RequestMapping(value="/admin/saveCompetenceCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void saveCompetenceCV(@RequestBody CompetenceForm f) {
		cvThequeService.addCompetenceToCV(f);
	}
	
	@RequestMapping(value="/cv/{id}/competences")
	public List<CV_COMP_RES> listCompsCV(@PathVariable("id") Long id){
		return cvThequeService.retreiveCompsCV(id);
	}
	
	@RequestMapping(value="/admin/addLanguesToCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void addLanguesToCV(@RequestBody LangueForm f) {
		cvThequeService.addLanguesToCV(f.getCv(),f.getLng());
	}
	
	@RequestMapping(value="/admin/saveLangueCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void saveLangueCV(@RequestBody LangueForm f) {
		
		cvThequeService.addLangueToCV(f);
	}
	
	@RequestMapping(value="/cv/{id}/langues")
	public List<CV_LNG_RES> listLanguesCV(@PathVariable("id") Long id){
		return cvThequeService.retreiveLanguesCV(id);
	}
	
	@RequestMapping(value="/admin/addSAsToCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void addSAsToCV(@RequestBody SaForm f) {
		cvThequeService.addSAsToCV(f.getCv(),f.getSa());
	}
	
	@RequestMapping(value="/admin/saveSaCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void saveSaCV(@RequestBody SaForm f) {
		cvThequeService.addSaToCV(f);
	}
	
	@RequestMapping(value="/cv/{id}/sas")
	public List<CV_SA_RES> listSAsCV(@PathVariable("id") Long id){
		return cvThequeService.retreiveSAsCV(id);
	}
	
	@RequestMapping(value="/admin/addSFsToCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void addSFsToCV(@RequestBody SfForm f) {
		cvThequeService.addSFsToCV(f.getCv(),f.getSf());
	}
	
	@RequestMapping(value="/admin/saveSfCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void saveSfCV(@RequestBody SfForm f) {
		cvThequeService.addSfToCV(f);
	}
	
	@RequestMapping(value="/cv/{id}/sfs")
	public List<CV_SF_RES> listSFsCV(@PathVariable("id") Long id){
		return cvThequeService.retreiveSFsCV(id);
	}
	
	@RequestMapping(value="/admin/addTPsToCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void addTPsToCV(@RequestBody TpForm f) {
		cvThequeService.addTPsToCV(f.getCv(),f.getTp());
	}
	
	@RequestMapping(value="/admin/saveTpCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void saveTpCV(@RequestBody TpForm f) {
		cvThequeService.addTpToCV(f);
	}
	
	@RequestMapping(value="/cv/{id}/tps")
	public List<CV_TP_RES> listTPsCV(@PathVariable("id") Long id){
		return cvThequeService.retreiveTPsCV(id);
	}
	
	@RequestMapping(value="/admin/addTCsToCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void addTCsToCV(@RequestBody TcForm f) {
		cvThequeService.addTCsToCV(f.getCv(),f.getTc());
	}
	
	@RequestMapping(value="/admin/saveTcCV",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void saveTcCV(@RequestBody TcForm f) {
		cvThequeService.addTcToCV(f);
	}
	
	@RequestMapping(value="/cv/{id}/tcs")
	public List<CV_TC_RES> listTCsCV(@PathVariable("id") Long id){
		return cvThequeService.retreiveTCsCV(id);
	}
	
	
	/*
	@RequestMapping(value="/admin/deleteCV/{id}",method = RequestMethod.DELETE)
	public void deleteCV(@PathVariable("id") Long id) {
		profilService.deleteCV(id);
	}*/
}
