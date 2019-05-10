package ma.hrpath.stage2019.erecrute.security.service;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	@Override
	public Langues saveLangues(Langues langues) {
		return languesRepository.save(langues);
	}

	@Override
	public Competence saveCompetence(Competence competence) {
		return competenceRepository.save(competence);
	}

	@Override
	public SecteurActivite saveSecteurActivite(SecteurActivite SA) {
		return secteurActiviteRepository.save(SA);
	}

	@Override
	public SituationFamiliale saveSituationFamiliale(SituationFamiliale SF) {
		return situationFamilialeRepository.save(SF) ;
	}

	@Override
	public TypeContrat saveTypeContrat(TypeContrat TC) {
		
		return typeContratRepository.save(TC);
	}

	@Override
	public TypeProfil saveTypeProfil(TypeProfil TP) {
		
		return typeProfilRepository.save(TP);
	}

}
