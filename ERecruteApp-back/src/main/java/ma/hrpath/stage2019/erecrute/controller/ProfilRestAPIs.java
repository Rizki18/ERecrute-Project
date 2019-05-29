package ma.hrpath.stage2019.erecrute.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ma.hrpath.stage2019.erecrute.message.request.FormationForm;
import ma.hrpath.stage2019.erecrute.message.request.SignUpForm;
import ma.hrpath.stage2019.erecrute.message.response.ResponseMessage;
import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.Competence;
import ma.hrpath.stage2019.erecrute.model.Formation;
import ma.hrpath.stage2019.erecrute.model.Profil;
import ma.hrpath.stage2019.erecrute.model.User;
import ma.hrpath.stage2019.erecrute.security.service.ProfilService;
import ma.hrpath.stage2019.erecrute.security.service.StorageService;;

@CrossOrigin(origins = "*")
@RestController
public class ProfilRestAPIs {
	@Autowired
	private ProfilService profilService;
	
	@RequestMapping(value="/profil")
	public List<Profil> listProfils(){
		return profilService.retreiveProfil();
	}
	
	@RequestMapping(value="/admin/saveProfil",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public Profil saveProfil(@RequestBody Profil p) {
		return profilService.saveProfil(p);	}
	
	@GetMapping(path="photoProfil/{id}",produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable("id") Long id) throws IOException
	{
		Profil p=profilService.findProfilById(id);
		//System.getProperty("user.home")+"/erecrute/profils/x.png"/*+
		return Files.readAllBytes(Paths.get(p.getPhoto()));
	}
	@RequestMapping(value="/admin/saveFormationProfil",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void saveProfilFormation(@RequestBody FormationForm f) {
		Formation formation = new Formation(f.getDateDebut(),f.getDateFin(),f.getDetails(),f.getEtablissement(),f.getIntitule(),f.getLieu());
		formation.setProfil(profilService.findProfilById(Long.valueOf(f.getProfil())));
		profilService.saveFormation(formation);
	}
	 /*@Autowired
	  StorageService storageService;
	 
	  List<String> files = new ArrayList<String>();
	 
	  @RequestMapping(value="/postfile" , method = RequestMethod.POST)
	  public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      storageService.store(file);
	      files.add(file.getOriginalFilename());
	 
	      message = "You successfully uploaded " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.OK).body(message);
	    } catch (Exception e) {
	      message = "FAIL to upload " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	    }
	  }
	 */
	 
	@RequestMapping(value="/admin/deleteProfil/{id}",method = RequestMethod.DELETE)
	public void deleteProfile(@PathVariable("id") Long id) {
		profilService.deleteProfil(id);
	}
	//Formation
	@RequestMapping(value="/formation")
	public List<Formation> listFormation(){
		return profilService.retreiveFormation();
	}
	
	@RequestMapping(value="/profil/{id}/formations")
	public List<Formation> listFormations(@PathVariable("id") Long id){
		return profilService.retreiveFormationsProfil(id);
	}
		
	@RequestMapping(value="/admin/saveFormation",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public Formation saveFomation(@RequestBody Formation p) {
		p.setProfil(profilService.findProfilByMaxId());
		return profilService.saveFormation(p);
	}
	/*
	@RequestMapping(value="/admin/updateFormation/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@RequestBody SignUpForm signUpRequest, @PathVariable long id) {
    
		Optional<Profil> ProfilOptional = profilService.findProfilById(id) ;
    
		if (!ProfilOptional.isPresent())
			return ResponseEntity.notFound().build();
    
		Profil profil = new Profil();
		profil.setCodeProfil(id);
		profilService.updateProfil(profil);
		
		return ResponseEntity.noContent().build();
	}*/
	
	@RequestMapping(value="/admin/deleteFormation/{id}",method = RequestMethod.DELETE)
	public void deleteFormation(@PathVariable("id") Long id) {
		profilService.deleteFormation(id);
	}
	
}
