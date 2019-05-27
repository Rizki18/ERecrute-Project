package ma.hrpath.stage2019.erecrute.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.hrpath.stage2019.erecrute.message.request.CvForm;
import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.Experience;
import ma.hrpath.stage2019.erecrute.model.Formation;
import ma.hrpath.stage2019.erecrute.model.Profil;
import ma.hrpath.stage2019.erecrute.security.service.CVThequeService;
import ma.hrpath.stage2019.erecrute.security.service.ProfilService;

@CrossOrigin(origins = "*")
@RestController
public class CVThequeRestAPIs {
	@Autowired
	private CVThequeService cvThequeService;
	
	@Autowired
	private ProfilService profilService;
	
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
	
	
	/*
	@RequestMapping(value="/admin/deleteCV/{id}",method = RequestMethod.DELETE)
	public void deleteCV(@PathVariable("id") Long id) {
		profilService.deleteCV(id);
	}*/
}
