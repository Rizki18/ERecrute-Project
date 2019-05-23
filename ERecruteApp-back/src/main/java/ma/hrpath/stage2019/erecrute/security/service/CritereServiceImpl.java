package ma.hrpath.stage2019.erecrute.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
@Transactional
public class CritereServiceImpl implements CritereService {

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
	
	/**Langues**/
	@Override
	public Langues saveLangues(Langues langues) {
		return languesRepository.save(langues);
	}
	@Override
	public void deleteLangues(long Langues) {
		languesRepository.deleteById(Langues);	
	}
	@Override
	public boolean findLanguesById(long langues) {
		if(languesRepository.findById(langues) != null)
			return true;
		return false;
	}
	@Override
	public Langues findLanguesByNAme(String name) {
		return languesRepository.findBylangue(name);
			
	}
	@Override
	public List<Langues> retreiveLangues() {
		return languesRepository.findAll();
	}
	
	@Override
	public List<String> retreiveLanguesName() {
		List<Langues> comp= languesRepository.findAll();
		List<String> l = new ArrayList();
		for(Langues c : comp)
		{
			l.add(c.getLangue());
		}
		return l;
	}
	
    /**Compétances**/
	@Override
	public Competence saveCompetence(Competence competence) {
		return competenceRepository.save(competence);
	}
	@Override
	public void deleteCompetence(long competence) {
		
		 competenceRepository.deleteById(competence);
	}
	@Override
	public List<Competence> retreiveCompetence() {
		
		return competenceRepository.findAll();
	}
	@Override
	public List<String> retreiveCompetenceName() {
		
		List<Competence> comp= competenceRepository.findAll();
		List<String> l = new ArrayList();
		for(Competence c : comp)
		{
			l.add(c.getNomCompetence());
		}
		return l;
	}
	@Override
	public boolean findCompetenceById(long competence) {
		if(competenceRepository.findById(competence) != null)
			return true;
		return false;
	}
	@Override
	public Competence findCompetenceByNAme(String name)
	{
		return competenceRepository.findBynomCompetence(name);
	}
	
	/**SecteurActivite**/
	@Override
	public void deleteSecteurActivite(long SA) {
		secteurActiviteRepository.deleteById(SA);
		
	}
	@Override
	public SecteurActivite saveSecteurActivite(SecteurActivite SA) {
		return secteurActiviteRepository.save(SA);
	}
	@Override
	public boolean findSecteurActiviteById(long SA) {
		if(secteurActiviteRepository.findById(SA) != null)
			return true;
		return false;
	}
	@Override
	public List<SecteurActivite> retreiveSecteurActivite() {
		return secteurActiviteRepository.findAll();
	}
	@Override
	public SecteurActivite findSecteurActiviteByNAme(String name)
	{
		return secteurActiviteRepository.findBylibelleSecteur(name);
	}
	
	@Override
	public List<String> retreiveSecteurActiviteName() {
		List<SecteurActivite> comp= secteurActiviteRepository.findAll();
		List<String> l = new ArrayList();
		for(SecteurActivite c : comp)
		{
			l.add(c.getLibelleSecteur());
		}
		return l;
	}
	/**SituationFamiliale**/
	@Override
	public SituationFamiliale saveSituationFamiliale(SituationFamiliale SF) {
		return situationFamilialeRepository.save(SF) ;
	}
	@Override
	public void deleteSituationFamiliale(long SF) {
		situationFamilialeRepository.deleteById(SF);
		
	}
	@Override
	public boolean findSituationFamilialeById(long SF) {
		if(situationFamilialeRepository.findById(SF) != null)
			return true;
		return false;
	}
	@Override
	public List<SituationFamiliale> retreiveSituationFamiliale() {
		return situationFamilialeRepository.findAll();
	}
	@Override
	public SituationFamiliale findSituationFamilialeByNAme(String name)
	{
		return situationFamilialeRepository.findBycivilite(name);
	}
	
	@Override
	public List<String> retreiveSituationFamilialeName() {
		List<SituationFamiliale> comp= situationFamilialeRepository.findAll();
		List<String> l = new ArrayList();
		for(SituationFamiliale c : comp)
		{
			l.add(c.getCivilite());
		}
		return l;
	}
	
	/**TypeContrat**/
	@Override
	public TypeContrat saveTypeContrat(TypeContrat TC) {
		
		return typeContratRepository.save(TC);
	}
	@Override
	public void deleteTypeContrat(long TC) {
		typeContratRepository.deleteById(TC);
		
	}

	@Override
	public boolean findTypeContratById(long TC) {
		if(typeContratRepository.findById(TC) != null)
			return true;
		return false;
	}

	@Override
	public List<TypeContrat> retreiveTypeContrat() {
		return typeContratRepository.findAll();
	}

	@Override
	public TypeContrat findTypeContratByNAme(String name)
	{
		return typeContratRepository.findBylibelleContrat(name);
	}
	
	@Override
	public List<String> retreiveTypeContratName() {
		List<TypeContrat> comp= typeContratRepository.findAll();
		List<String> l = new ArrayList();
		for(TypeContrat c : comp)
		{
			l.add(c.getLibelleContrat());
		}
		return l;
	}
	/**TypeProfil**/
	@Override
	public TypeProfil saveTypeProfil(TypeProfil TP) {
		
		return typeProfilRepository.save(TP);
	}
	@Override
	public void deleteTypeProfil(long TP) {
		typeProfilRepository.deleteById(TP);
	}
	@Override
	public boolean findTypeProfilById(long TP) {
		if(typeProfilRepository.findById(TP) != null)
			return true;
		return false;
	}
	@Override
	public List<TypeProfil> retreiveTypeProfil() {
		return typeProfilRepository.findAll();
	}
	@Override
	public TypeProfil findTypeProfilByNAme(String name)
	{
		return typeProfilRepository.findBylibelleProfil(name);
	}
	
	@Override
	public List<String> retreiveTypeProfilName() {
		List<TypeProfil> comp= typeProfilRepository.findAll();
		List<String> l = new ArrayList();
		for(TypeProfil c : comp)
		{
			l.add(c.getLibelleProfil());
		}
		return l;
	}

}
