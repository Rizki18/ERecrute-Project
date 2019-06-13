package ma.hrpath.stage2019.erecrute.security.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hrpath.stage2019.erecrute.message.request.CompetenceForm;
import ma.hrpath.stage2019.erecrute.message.request.CvForm;
import ma.hrpath.stage2019.erecrute.message.request.ExperienceForm;
import ma.hrpath.stage2019.erecrute.message.request.LangueForm;
import ma.hrpath.stage2019.erecrute.message.request.SaForm;
import ma.hrpath.stage2019.erecrute.message.request.SfForm;
import ma.hrpath.stage2019.erecrute.message.request.TcForm;
import ma.hrpath.stage2019.erecrute.message.request.TpForm;
import ma.hrpath.stage2019.erecrute.message.response.CV_COMP_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_LNG_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_SA_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_SF_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_TC_RES;
import ma.hrpath.stage2019.erecrute.message.response.CV_TP_RES;
import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.model.CV_COMP;
import ma.hrpath.stage2019.erecrute.model.CV_LNG;
import ma.hrpath.stage2019.erecrute.model.CV_SA;
import ma.hrpath.stage2019.erecrute.model.CV_SF;
import ma.hrpath.stage2019.erecrute.model.CV_TC;
import ma.hrpath.stage2019.erecrute.model.CV_TP;
import ma.hrpath.stage2019.erecrute.model.Competence;
import ma.hrpath.stage2019.erecrute.model.Experience;
import ma.hrpath.stage2019.erecrute.model.Langues;
import ma.hrpath.stage2019.erecrute.model.MotCles;
import ma.hrpath.stage2019.erecrute.model.Poste;
import ma.hrpath.stage2019.erecrute.model.Profil;
import ma.hrpath.stage2019.erecrute.model.Role;
import ma.hrpath.stage2019.erecrute.model.RoleName;
import ma.hrpath.stage2019.erecrute.model.SecteurActivite;
import ma.hrpath.stage2019.erecrute.model.SituationFamiliale;
import ma.hrpath.stage2019.erecrute.model.Societe;
import ma.hrpath.stage2019.erecrute.model.TypeContrat;
import ma.hrpath.stage2019.erecrute.model.TypeProfil;
import ma.hrpath.stage2019.erecrute.model.User;
import ma.hrpath.stage2019.erecrute.repository.CompetenceRepository;
import ma.hrpath.stage2019.erecrute.repository.CvRepository;
import ma.hrpath.stage2019.erecrute.repository.ExperienceRepository;
import ma.hrpath.stage2019.erecrute.repository.LanguesRepository;
import ma.hrpath.stage2019.erecrute.repository.MotclesRepository;
import ma.hrpath.stage2019.erecrute.repository.PosteRepository;
import ma.hrpath.stage2019.erecrute.repository.ProfilRepository;
import ma.hrpath.stage2019.erecrute.repository.SecteurActiviteRepository;
import ma.hrpath.stage2019.erecrute.repository.SituationFamilialeRepository;
import ma.hrpath.stage2019.erecrute.repository.SocieteRepository;
import ma.hrpath.stage2019.erecrute.repository.TypeContratRepository;
import ma.hrpath.stage2019.erecrute.repository.TypeProfilRepository;

@Service
@Transactional
public class CVThequeServiceImpl implements CVThequeService{
	
	@Autowired
	private CvRepository cvRepository;
	@Autowired
	private ProfilService profilService;
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private ExperienceRepository expRepository;
	@Autowired
	private PosteRepository posteRepository;
	@Autowired
	private SocieteRepository steRepository;
	@Autowired
	private CompetenceRepository compRepository;
	@Autowired
	private LanguesRepository lngRepository;
	@Autowired
	private SecteurActiviteRepository saRepository;
	@Autowired
	private SituationFamilialeRepository sfRepository;
	@Autowired
	private TypeProfilRepository tpRepository;
	@Autowired
	private TypeContratRepository tcRepository;
	@Autowired
	private MotclesRepository mcRepository;
	
	@Override
	public CV saveCV(CvForm cv) {
		CV newCV = new CV(cv.getModele(),cv.getNomCV(),cv.getPosteDesire());
		Profil profil = profilService.findProfilById(Long.valueOf(cv.getProfil()));
		newCV.setProfil(profil);
		return cvRepository.save(newCV);
	}

	@Override
	public List<CV> retreiveCVs() {
		// TODO Auto-generated method stub
		return cvRepository.findAll();
	}
	
	@Override
	public CV retreiveCvById(Long id) {
		// TODO Auto-generated method stub
		return cvRepository.findById(id).orElse(null);
	}

	@Override
	public List<CV> retreiveCVsProfil(Long id) {
		//Profil p = profilService.findProfilById(id);
		return cvRepository.findByProfil(id);
	}

	@Override
	public List<Experience> retreiveExpsCV(Long id) {
		List<Experience> exps = new ArrayList<Experience>();
		
		CV cv = cvRepository.findById(id).orElse(null);
		
		for(Experience exp : cv.getExps())
			exps.add(exp);
			
		return exps;
	}

	@Override
	public Set<Experience> retreiveExpsProfil(Long id) {
		List<CV> cvs = this.retreiveCVsProfil(id);
		Set<Experience> exps = new HashSet<Experience>();
		for(CV cv : cvs) {
			exps.addAll(cv.getExps());
		}
		
		return exps;
	}

	@Override
	public List<CV_COMP_RES> retreiveCompsCV(Long id) {
		List<CV_COMP_RES> comps = new ArrayList<CV_COMP_RES>();
		
		CV cv = cvRepository.findById(id).orElse(null);
		
		for(CV_COMP comp : cv.getM_competences())
			comps.add(new CV_COMP_RES(comp.getComp().getCodeCompetance(),comp.getComp().getNomCompetence(),comp.getDetail(),comp.getNiveau()));
		
		System.out.println(comps);
			
		return comps;
	}

	@Override
	public void saveExperience(ExperienceForm f) {
		CV cv = retreiveCvById(Long.valueOf(f.getCv()));
		Profil profil = profilRepository.findBycodeProfil(Long.valueOf(f.getProfil()));
		Set<Experience> exps,exps2;
		
		GregorianCalendar calendar = new GregorianCalendar(); 
		calendar.setTime(f.getDateDebut()); 
		String descRole = f.getDescriptionRole() + "_" +
				calendar.get(GregorianCalendar.DAY_OF_MONTH) + "_" +
				(calendar.get(GregorianCalendar.MONTH) + 1);
				
		Experience exp = new Experience(f.getDateDebut(),f.getDateFin(),f.getDepartement(),descRole);

		exp.setPoste(posteRepository.findById(Long.valueOf(f.getPoste())).orElse(null));
		exp.setSociete(steRepository.findById(Long.valueOf(f.getSociete())).orElse(null));
		exp.setProfil(profilRepository.findById(Long.valueOf(f.getProfil())).orElse(null));
		expRepository.save(exp);
		System.out.println(exp);

		exps = cv.getExps();
		exps2 = profil.getM_Experience();

		exps.add(exp);
		exps2.add(exp);
		
		cv.setExps(exps);
		profil.setM_Experience(exps2);
		cvRepository.save(cv);
		profilRepository.save(profil);
	}


	@Override
	public void addExperienceToCV(String idCV,Set<String> exp) {
		CV cv = retreiveCvById(Long.valueOf(idCV));
		Set<Experience> exps;
		
		exps = new HashSet<Experience>();
		
		for(String e : exp) {
			exps.add(expRepository.findById(Long.valueOf(e)).orElse(null));
		}
		
		cv.setExps(exps);
		cvRepository.save(cv);
	}
	
	@Override
	public void addMCToExperience(String descRole, Set<String> strMCs) {
		Experience exp = expRepository.findByDescriptionRole(descRole);
		
		Set<MotCles> mcs = new HashSet<>();

		strMCs.forEach(mc -> {
			MotCles recMC = mcRepository.findBylibelleMotCle(mc);
			mcs.add(recMC);
		});
		
		System.out.println(mcs);
	
		exp.setMotcles(mcs);
		
		

	}

	@Override
	public void addCompetencesToCV(String idCV,Set<String> comp) {
		
	}
	
	@Override
	public void addCompetenceToCV(CompetenceForm f) {

		CV cv = retreiveCvById(Long.valueOf(f.getCv()));
		
		Competence comp = compRepository.findById(Long.valueOf(f.getCompetence())).orElse(null);
		CV_COMP compCV = new CV_COMP(cv,comp,f.getDetails(),Double.valueOf(f.getNiveau()));

		cv.getM_competences().add(compCV); 
		
		cvRepository.save(cv);
		
	}
	

	@Override
	public void addLanguesToCV(String cv, String langue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLangueToCV(LangueForm f) {
		CV cv = retreiveCvById(Long.valueOf(f.getCv()));
		
		Langues lng = lngRepository.findById(Long.valueOf(f.getLng())).orElse(null);
		CV_LNG lngCV = new CV_LNG(cv,lng,Double.valueOf(f.getNiveau()),f.getDetails());
		System.out.println(lngCV);
		cv.getM_langues().add(lngCV); 
		
		cvRepository.save(cv);
	}

	@Override
	public List<CV_LNG_RES> retreiveLanguesCV(Long id) {
		List<CV_LNG_RES> lngs = new ArrayList<CV_LNG_RES>();
		
		CV cv = cvRepository.findById(id).orElse(null);
		
		for(CV_LNG lng : cv.getM_langues())
			lngs.add(new CV_LNG_RES(lng.getLng().getCodeLangue(),lng.getLng().getLangue(),lng.getDetails(),lng.getNiveau()));
		
		System.out.println(lngs);
			
		return lngs;
	}

	@Override
	public void addSAsToCV(String cv, String sa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSaToCV(SaForm f) {
		CV cv = retreiveCvById(Long.valueOf(f.getCv()));
		
		SecteurActivite sa = saRepository.findById(Long.valueOf(f.getSa())).orElse(null);
		CV_SA saCV = new CV_SA(cv,sa,f.getDd(),f.getDf());

		cv.getM_secteurActivites().add(saCV); 
		
		cvRepository.save(cv);
	}

	@Override
	public List<CV_SA_RES> retreiveSAsCV(Long id) {
		List<CV_SA_RES> sas = new ArrayList<CV_SA_RES>();
	
		CV cv = cvRepository.findById(id).orElse(null);
		
		for(CV_SA sa : cv.getM_secteurActivites())
			sas.add(new CV_SA_RES(sa.getSa().getCodeSecteur(),sa.getSa().getLibelleSecteur(),sa.getDateDebut(),sa.getDateFin()));
		
		return sas;
	}

	@Override
	public void addSFsToCV(String cv, String sf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSfToCV(SfForm f) {
		CV cv = retreiveCvById(Long.valueOf(f.getCv()));
		
		SituationFamiliale sf = sfRepository.findById(Long.valueOf(f.getSf())).orElse(null);
		CV_SF sfCV = new CV_SF(cv,sf,f.getDd(),f.getDf());

		cv.getM_situationFamiliales().add(sfCV); 
		
		cvRepository.save(cv);
		
	}

	@Override
	public List<CV_SF_RES> retreiveSFsCV(Long id) {
		List<CV_SF_RES> sfs = new ArrayList<CV_SF_RES>();
		
		CV cv = cvRepository.findById(id).orElse(null);
		
		for(CV_SF sf : cv.getM_situationFamiliales())
			sfs.add(new CV_SF_RES(sf.getSf().getCodeSituationFamiliale(),sf.getSf().getCivilite(),sf.getDateDebut(),sf.getDateFin()));
		
		return sfs;
	}

	@Override
	public void addTPsToCV(String cv, String tp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTpToCV(TpForm f) {
		CV cv = retreiveCvById(Long.valueOf(f.getCv()));

		TypeProfil tp = tpRepository.findById(Long.valueOf(f.getTp())).orElse(null);
		CV_TP tpCV = new CV_TP(cv,tp,f.getDd(),f.getDf());

		cv.getM_typeProfils().add(tpCV); 
		
		cvRepository.save(cv);
	}

	@Override
	public List<CV_TP_RES> retreiveTPsCV(Long id) {
		List<CV_TP_RES> tps = new ArrayList<CV_TP_RES>();
		
		CV cv = cvRepository.findById(id).orElse(null);
		
		for(CV_TP tp : cv.getM_typeProfils())
			tps.add(new CV_TP_RES(tp.getTp().getCodeTypeProfil(),tp.getTp().getLibelleProfil(),tp.getDateDebut(),tp.getDateFin()));
		
		return tps;
	}

	@Override
	public void addTCsToCV(String cv, String tc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTcToCV(TcForm f) {
		CV cv = retreiveCvById(Long.valueOf(f.getCv()));
		
		TypeContrat tc = tcRepository.findById(Long.valueOf(f.getTc())).orElse(null);
		CV_TC tcCV = new CV_TC(cv,tc,f.getDd(),f.getDf());

		cv.getM_typeContrats().add(tcCV); 
		
		cvRepository.save(cv);
	}

	@Override
	public List<CV_TC_RES> retreiveTCsCV(Long id) {
		List<CV_TC_RES> tcs = new ArrayList<CV_TC_RES>();
		
		CV cv = cvRepository.findById(id).orElse(null);
		
		for(CV_TC tc : cv.getM_typeContrats())
			tcs.add(new CV_TC_RES(tc.getTc().getCodeTypeContrat(),tc.getTc().getLibelleContrat(),tc.getDateDebut(),tc.getDateFin()));
		
		return tcs;
	}

}
