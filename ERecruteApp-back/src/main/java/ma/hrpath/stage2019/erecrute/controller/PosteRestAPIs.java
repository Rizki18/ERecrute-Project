package ma.hrpath.stage2019.erecrute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.hrpath.stage2019.erecrute.model.Poste;
import ma.hrpath.stage2019.erecrute.model.Societe;
import ma.hrpath.stage2019.erecrute.security.service.PosteService;

@CrossOrigin("*")
@RestController
public class PosteRestAPIs {
	@Autowired
	private PosteService PosteService ;
	
	//Poste
	@RequestMapping(value="/admin/savePoste",method = RequestMethod.POST)

	public Poste savePoste(@RequestBody Poste p) {
		return PosteService.savePoste(p);
	}
	@RequestMapping(value="/admin/deletePoste/{codePost}",method = RequestMethod.DELETE)

	public void deletePoste(@PathVariable("codePost") Long codePost) {
		PosteService.deletePoste(codePost);
	}
	@RequestMapping(value="/Poste")

	public List<Poste> listPoste(){
		return PosteService.retreivePoste();
	}
	@Autowired
	private PosteService SocieteService;
	
	//Societe
	@RequestMapping(value="/admin/saveSociete",method = RequestMethod.POST)

	public Societe saveSociete(@RequestBody Societe p) {
		return SocieteService.saveSociete(p);
	}
	@RequestMapping(value="/admin/deleteSociete/{codePost}",method = RequestMethod.DELETE)

	public void deleteSociete(@PathVariable("codePost") Long codePost) {
		SocieteService.deleteSociete(codePost);
	}
	@RequestMapping(value="/Societe")

	public List<Societe> listSociete(){
		return SocieteService.retreiveSociete();
	}

	
}
