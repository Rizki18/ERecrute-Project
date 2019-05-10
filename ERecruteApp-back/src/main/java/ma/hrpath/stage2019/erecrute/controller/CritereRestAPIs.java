package ma.hrpath.stage2019.erecrute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin("*")
@RestController
public class CritereRestAPIs {
	
	@Autowired
	private CompetenceRepository competenceRepository ;
	@Autowired
	private LanguesRepository languesRepository ;
	@Autowired
	private SecteurActiviteRepository secteurActiviteRepository ;
	@Autowired
	private SituationFamilialeRepository situationFamilialeRepository ;
	@Autowired
	private TypeContratRepository typeContratRepository ;
	@Autowired
	private TypeProfilRepository typeProfilRepository ;
	
	//Competence
	@RequestMapping(value="/admin/saveCompetence",method = RequestMethod.POST)
	public Competence saveCompetence(@RequestBody Competence p) {
		return competenceRepository.save(p);
	}
	@RequestMapping(value="/admin/deleteCompetence/{codeCompetance}",method = RequestMethod.DELETE)
	public void deleteCompetence(@PathVariable("codeCompetance") Long codeCompetance) {
		competenceRepository.deleteById(codeCompetance);
	}
		@RequestMapping(value="/Competence")
	public List<Competence> listCompetence(){
		return competenceRepository.findAll();
	}

	
	//SecteurActivite
	@RequestMapping(value="/admin/saveSecteur",method = RequestMethod.POST)
	public SecteurActivite saveSecteurActivite(@RequestBody SecteurActivite p) {
		return secteurActiviteRepository.save(p);
	}
	@RequestMapping(value="/admin/Secteur/{codeSecteur}",method = RequestMethod.DELETE)
	public void deleteSecteur(@PathVariable("codeSecteur") Long id) {
		competenceRepository.deleteById(id);
	}
		@RequestMapping(value="/Secteur")
	public List<SecteurActivite> listSecteurActivite(){
		return secteurActiviteRepository.findAll();
	}
	//SituationFamiliale
	@RequestMapping(value="/admin/saveSituationFamiliale",method = RequestMethod.POST)
	public SituationFamiliale saveSituationFamiliale(@RequestBody SituationFamiliale p) {
		return situationFamilialeRepository.save(p);
	}
	@RequestMapping(value="/admin/SituationFamiliale/{id}",method = RequestMethod.DELETE)
	public void deleteSituationFamiliale(@PathVariable("id") Long id) {
		situationFamilialeRepository.deleteById(id);
	}
	@RequestMapping(value="/SituationFamiliale")
	public List<SituationFamiliale> listSituationFamiliale(){
		return situationFamilialeRepository.findAll();
	}
	//TypeContrat
	@RequestMapping(value="/admin/saveTypeContrat",method = RequestMethod.POST)
	public TypeContrat saveTypeContrat(@RequestBody TypeContrat p) {
		return typeContratRepository.save(p);
	}
	@RequestMapping(value="/admin/TypeContrat/{id}",method = RequestMethod.DELETE)
	public void deleteTypeContrat(@PathVariable("id") Long id) {
		typeContratRepository.deleteById(id);
	}
	@RequestMapping(value="/TypeContrat")
	public List<TypeContrat> listTypeContrat(){
		return typeContratRepository.findAll();
	}
	//TypeProfil
	@RequestMapping(value="/admin/saveTypeProfil",method = RequestMethod.POST)
	public TypeProfil saveTypeProfil(@RequestBody TypeProfil p) {
		return typeProfilRepository.save(p);
	}
	@RequestMapping(value="/admin/TypeProfil/{id}",method = RequestMethod.DELETE)
	public void deleteTypeProfil(@PathVariable("id") Long id) {
		typeProfilRepository.deleteById(id);
	}
	@RequestMapping(value="/TypeProfil")
	public List<TypeProfil> listTypeProfil(){
		return typeProfilRepository.findAll();
	}
}	
