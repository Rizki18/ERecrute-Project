package ma.hrpath.stage2019.erecrute.security.service;

import ma.hrpath.stage2019.erecrute.model.Competence;
import ma.hrpath.stage2019.erecrute.model.Langues;
import ma.hrpath.stage2019.erecrute.model.SecteurActivite;
import ma.hrpath.stage2019.erecrute.model.SituationFamiliale;
import ma.hrpath.stage2019.erecrute.model.TypeContrat;
import ma.hrpath.stage2019.erecrute.model.TypeProfil;

public interface CritereService {
	public Langues saveLangues(Langues langues) ;
	public Competence saveCompetence(Competence competence);
	public SecteurActivite saveSecteurActivite(SecteurActivite SA);
	public SituationFamiliale saveSituationFamiliale(SituationFamiliale SF);
	public TypeContrat saveTypeContrat(TypeContrat TC);
	public TypeProfil saveTypeProfil(TypeProfil SA);
}
