package ma.hrpath.stage2019.erecrute.security.service;

import java.util.List;

import ma.hrpath.stage2019.erecrute.model.Competence;
import ma.hrpath.stage2019.erecrute.model.Langues;
import ma.hrpath.stage2019.erecrute.model.SecteurActivite;
import ma.hrpath.stage2019.erecrute.model.SituationFamiliale;
import ma.hrpath.stage2019.erecrute.model.TypeContrat;
import ma.hrpath.stage2019.erecrute.model.TypeProfil;

public interface CritereService {
	public Langues saveLangues(Langues langues) ;
	public void deleteLangues(long Langues);
	public boolean findLanguesById(long Langues);
	public Langues findLanguesByNAme(String name);
	public List<Langues> retreiveLangues();
	public List<String> retreiveLanguesName();
	
	public Competence saveCompetence(Competence competence);
	public void deleteCompetence(long competence);
	public boolean findCompetenceById(long competence);
	public Competence findCompetenceByNAme(String name);
	public List<Competence> retreiveCompetence();
	public List<String> retreiveCompetenceName();
	
	public SecteurActivite saveSecteurActivite(SecteurActivite SA);
	public void deleteSecteurActivite(long SecteurActivite);
	public boolean findSecteurActiviteById(long SecteurActivite);
	public SecteurActivite findSecteurActiviteByNAme(String name);
	public List<SecteurActivite> retreiveSecteurActivite();
	public List<String> retreiveSecteurActiviteName();
	
	public SituationFamiliale saveSituationFamiliale(SituationFamiliale SF);
	public void deleteSituationFamiliale(long SituationFamiliale);
	public boolean findSituationFamilialeById(long SituationFamiliale);
	public SituationFamiliale findSituationFamilialeByNAme(String name);
	public List<SituationFamiliale> retreiveSituationFamiliale();
	public List<String> retreiveSituationFamilialeName();

	
	public TypeContrat saveTypeContrat(TypeContrat TC);
	public void deleteTypeContrat(long TypeContrat);
	public boolean findTypeContratById(long TypeContrat);
	public TypeContrat findTypeContratByNAme(String name);
	public List<TypeContrat> retreiveTypeContrat();
	public List<String> retreiveTypeContratName();
	
	public TypeProfil saveTypeProfil(TypeProfil SA);
	public void deleteTypeProfil(long TypeProfil);
	public boolean findTypeProfilById(long TypeProfil);
	public TypeProfil findTypeProfilByNAme(String name);
	public List<TypeProfil> retreiveTypeProfil();
	public List<String> retreiveTypeProfilName();
}
