package ma.hrpath.stage2019.erecrute.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.hrpath.stage2019.erecrute.message.request.CvForm;
import ma.hrpath.stage2019.erecrute.model.CV;
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
	
	@RequestMapping(value="/cvs")
	public List<CV> listFormation(){
		return cvThequeService.retreiveCVs();
	}
}
