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

import ma.hrpath.stage2019.erecrute.model.Competence;
import ma.hrpath.stage2019.erecrute.model.SecteurActivite;
import ma.hrpath.stage2019.erecrute.model.SituationFamiliale;
import ma.hrpath.stage2019.erecrute.model.TypeContrat;
import ma.hrpath.stage2019.erecrute.model.TypeProfil;
import ma.hrpath.stage2019.erecrute.repository.CompetenceRepository;
import ma.hrpath.stage2019.erecrute.repository.LanguesRepository;
import ma.hrpath.stage2019.erecrute.repository.SecteurActiviteRepository;
import ma.hrpath.stage2019.erecrute.repository.SituationFamilialeRepository;
import ma.hrpath.stage2019.erecrute.repository.TypeContratRepository;
import ma.hrpath.stage2019.erecrute.repository.TypeProfilRepository;
import ma.hrpath.stage2019.erecrute.security.service.CritereService;

@CrossOrigin("*")
@RestController
public class CritereRestAPIs {

	@Autowired
	private CritereService CritereService ;
	
	//Competence
	@RequestMapping(value="/admin/saveCompetence",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public Competence saveCompetence(@RequestBody Competence p) {
		return CritereService.saveCompetence(p);
	}
	@RequestMapping(value="/admin/deleteCompetence/{codeCompetance}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteCompetence(@PathVariable("codeCompetance") Long codeCompetance) {
		CritereService.deleteCompetence(codeCompetance);
	}
	@RequestMapping(value="/Competence")
	public List<Competence> listCompetence(){
		return CritereService.retreiveCompetence();
	}

	
	//SecteurActivite
	@RequestMapping(value="/admin/saveSecteur",method = RequestMethod.POST)
	public SecteurActivite saveSecteurActivite(@RequestBody SecteurActivite p) {
		return CritereService.saveSecteurActivite(p);
	}
	@RequestMapping(value="/admin/Secteur/{codeSecteur}",method = RequestMethod.DELETE)
	public void deleteSecteur(@PathVariable("codeSecteur") Long id) {
		CritereService.deleteSecteurActivite(id);
	}
		@RequestMapping(value="/Secteur")
	public List<SecteurActivite> listSecteurActivite(){
		return CritereService.retreiveSecteurActivite();
	}
	//SituationFamiliale
	@RequestMapping(value="/admin/saveSituationFamiliale",method = RequestMethod.POST)
	public SituationFamiliale saveSituationFamiliale(@RequestBody SituationFamiliale p) {
		return CritereService.saveSituationFamiliale(p);
	}
	@RequestMapping(value="/admin/SituationFamiliale/{id}",method = RequestMethod.DELETE)
	public void deleteSituationFamiliale(@PathVariable("id") Long id) {
		CritereService.deleteSituationFamiliale(id);
	}
	@RequestMapping(value="/SituationFamiliale")
	public List<SituationFamiliale> listSituationFamiliale(){
		return CritereService.retreiveSituationFamiliale();
	}
	//TypeContrat
	@RequestMapping(value="/admin/saveTypeContrat",method = RequestMethod.POST)
	public TypeContrat saveTypeContrat(@RequestBody TypeContrat p) {
		return CritereService.saveTypeContrat(p);
	}
	@RequestMapping(value="/admin/TypeContrat/{id}",method = RequestMethod.DELETE)
	public void deleteTypeContrat(@PathVariable("id") Long id) {
		CritereService.deleteTypeContrat(id);
	}
	@RequestMapping(value="/TypeContrat")
	public List<TypeContrat> listTypeContrat(){
		return CritereService.retreiveTypeContrat();
	}
	//TypeProfil
	@RequestMapping(value="/admin/saveTypeProfil",method = RequestMethod.POST)
	public TypeProfil saveTypeProfil(@RequestBody TypeProfil p) {
		return CritereService.saveTypeProfil(p);
	}
	@RequestMapping(value="/admin/TypeProfil/{id}",method = RequestMethod.DELETE)
	public void deleteTypeProfil(@PathVariable("id") Long id) {
		CritereService.deleteTypeProfil(id);
	}
	@RequestMapping(value="/TypeProfil")
	public List<TypeProfil> listTypeProfil(){
		return CritereService.retreiveTypeProfil();
	}
}	
