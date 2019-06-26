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
import ma.hrpath.stage2019.erecrute.model.Langues;
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
	@RequestMapping(value="/CompetenceName")
	public List<String> listCompetenceName(){
		return CritereService.retreiveCompetenceName();
	}

	@RequestMapping(value="/CompetenceByName")
	public Competence CompetenceName(@PathVariable("nomCompetence") String name){
		return CritereService.findCompetenceByNAme(name);
	}
	//Langues
	@RequestMapping(value="/admin/saveLangues",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public Langues saveLangues(@RequestBody Langues p) {
		return CritereService.saveLangues(p);
	}
	@RequestMapping(value="/admin/deleteLangues/{codeLAngues}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteLangues(@PathVariable("codeLangues") Long codeLangue) {
		CritereService.deleteLangues(codeLangue);
	}
	@RequestMapping(value="/Langues")
	public List<Langues> listLangues(){
		return CritereService.retreiveLangues();
	}
	@RequestMapping(value="/LangueName")
	public List<String> listLangueName(){
		return CritereService.retreiveLanguesName();
	}

	@RequestMapping(value="/LangueByName")
	public Langues LangueName(@PathVariable("langue") String name){
		return CritereService.findLanguesByNAme(name);
	}
	//SecteurActivite
	@RequestMapping(value="/admin/saveSecteur",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public SecteurActivite saveSecteurActivite(@RequestBody SecteurActivite p) {
		return CritereService.saveSecteurActivite(p);
	}
	@RequestMapping(value="/admin/deleteSecteur/{codeSecteur}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteSecteur(@PathVariable("codeSecteur") Long id) {
		CritereService.deleteSecteurActivite(id);
	}
		@RequestMapping(value="/Secteur")
	public List<SecteurActivite> listSecteurActivite(){
		return CritereService.retreiveSecteurActivite();
	}
	@RequestMapping(value="/SecteurName")
	public List<String> listSecteurName(){
		return CritereService.retreiveSecteurActiviteName();
	}

	@RequestMapping(value="/SecteurByName")
	public SecteurActivite SecteurName(@PathVariable("libelleSecteur") String name){
		return CritereService.findSecteurActiviteByNAme(name);
	}
	//SituationFamiliale
	@RequestMapping(value="/admin/saveSituationFamiliale",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public SituationFamiliale saveSituationFamiliale(@RequestBody SituationFamiliale p) {
		return CritereService.saveSituationFamiliale(p);
	}
	@RequestMapping(value="/admin/deleteSituationFamiliale/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteSituationFamiliale(@PathVariable("id") Long id) {
		CritereService.deleteSituationFamiliale(id);
	}
	@RequestMapping(value="/SituationFamiliale")
	public List<SituationFamiliale> listSituationFamiliale(){
		return CritereService.retreiveSituationFamiliale();
	}
	@RequestMapping(value="/SituationFamilialeName")
	public List<String> listSituationFamilialeName(){
		return CritereService.retreiveSituationFamilialeName();
	}

	@RequestMapping(value="/SituationFamilialeByName")
	public SituationFamiliale SituationFamilialeName(@PathVariable("civilite") String name){
		return CritereService.findSituationFamilialeByNAme(name);
	}
	//TypeContrat
	@RequestMapping(value="/admin/saveTypeContrat",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public TypeContrat saveTypeContrat(@RequestBody TypeContrat p) {
		return CritereService.saveTypeContrat(p);
	}
	@RequestMapping(value="/admin/deleteTypeContrat/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteTypeContrat(@PathVariable("id") Long id) {
		CritereService.deleteTypeContrat(id);
	}
	@RequestMapping(value="/TypeContrat")
	public List<TypeContrat> listTypeContrat(){
		return CritereService.retreiveTypeContrat();
	}
	@RequestMapping(value="/TypeContratName")
	public List<String> listTypeContratName(){
		return CritereService.retreiveTypeContratName();
	}

	@RequestMapping(value="/TypeContratByName")
	public TypeContrat TypeContratName(@PathVariable("libelleContrat") String name){
		return CritereService.findTypeContratByNAme(name);
	}
	//TypeProfil
	@RequestMapping(value="/admin/saveTypeProfil",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public TypeProfil saveTypeProfil(@RequestBody TypeProfil p) {
		return CritereService.saveTypeProfil(p);
	}
	@RequestMapping(value="/admin/deleteTypeProfil/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteTypeProfil(@PathVariable("id") Long id) {
		CritereService.deleteTypeProfil(id);
	}
	@RequestMapping(value="/TypeProfil")
	public List<TypeProfil> listTypeProfil(){
		return CritereService.retreiveTypeProfil();
	}
	@RequestMapping(value="/TypeProfilName")
	public List<String> listTypeProfilName(){
		return CritereService.retreiveTypeProfilName();
	}

	@RequestMapping(value="/TypeProfilByName")
	public TypeProfil TypeProfilName(@PathVariable("libelleProfil") String name){
		return CritereService.findTypeProfilByNAme(name);
	}
}	
