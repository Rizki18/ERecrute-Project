package ma.hrpath.stage2019.erecrute.security.service;

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
	public List<Langues> retreiveLangues() {
		return languesRepository.findAll();
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
	public boolean findCompetenceById(long competence) {
		if(competenceRepository.findById(competence) != null)
			return true;
		return false;
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

}
