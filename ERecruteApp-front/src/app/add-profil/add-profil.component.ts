import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpEventType, HttpClient, HttpRequest, HttpEvent, HttpResponse } from '@angular/common/http';
import { UserService, Profil, Formation, CV, Experience, CompetenceCV, LngCV, SaCV, SfCV, TpCV, TcCV } from '../services/user.service';
@Component({
  selector: 'app-add-profil',
  templateUrl: './add-profil.component.html',
  styleUrls: ['./add-profil.component.css']
})

export class AddProfilComponent implements OnInit {

  private Profil;
  private Formation;
  competences; dlcompetence; sIcompetence = [];
  langues; dllangue; sIlangue = [];
  secteurActivite; dlsecteurActivite; sIsecteurActivite = [];
  situationFamiliale; dlsituationFamiliale; sIsituationFamiliale = [];
  TypeContact; dltypeContrat; sItypeContact = [];
  TypeProfil; dltypeProfil; sItypeProfil = [];
  dropdownSettings = {};
  experiences; sImc_exp; sIposte; sIsociete;
  postes; societes; mcs; mcs_exp; poste; societe;
  dlposte; dlsociete; dlmc;
  dropdownSettingsSingle = {};
  sIcomp; dlcomp; sIlng; dllng; sIsa; dlsa; sIsf; dlsf; sItp; dltp; sItc; dltc;
  comps; lngs; sas; sfs; tps; tcs;
  selectedComps=[]; selectedLngs=[]; selectedSas; selectedSfs; selectedTps; selectedTcs;

  formations;
  codeProfil; codeCV;

  constructor(
    private service: UserService, private router: Router) { }
  ngOnInit(): void {
    this.dropdownSettings = {
      singleSelection: false,
      itemsShowLimit: 5,
      allowSearchFilter: true
    };

    this.getPostes("/postes");
    this.getSocietes("/societes");
    this.getMCs("/MotclesName");

    this.getCompetences("/Competence");
    this.getLangues("/Langues");

    this.service.getRessources("/CompetenceName")
      .subscribe(data => {
        this.dlcompetence = data;
      }, err => {
        console.log(err);
      });
    this.service.getRessources("/LangueName")
      .subscribe(data => {
        this.dllangue = data;
      }, err => {
        console.log(err);
      });
    this.service.getRessources("/SecteurName")
      .subscribe(data => {
        this.dlsecteurActivite = data;
      }, err => {
        console.log(err);
      });
    this.service.getRessources("/SituationFamilialeName")
      .subscribe(data => {
        this.dlsituationFamiliale = data;
        console.log(this.dlsituationFamiliale);
      }, err => {
        console.log(err);
      });
    this.service.getRessources("/TypeContratName")
      .subscribe(data => {
        this.dltypeContrat = data;
      }, err => {
        console.log(err);
      });
    this.service.getRessources("/TypeProfilName")
      .subscribe(data => {
        this.dltypeProfil = data;
      }, err => {
        console.log(err);
      });
  }
  onItemSelect(item: any) {
    //this.authority = item;
  }

  getPostes(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.postes = data;

        this.dlposte = [];
        for (let p of this.postes) {
          this.dlposte.push(p.libellePost);
        }

      }, err => {
        console.log(err);
      })
  }

  getCompetences(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.comps = data;

        this.dlcomp = [];
        for (let s of this.comps) {
          this.dlcomp.push(s.nomCompetence);
        }

      }, err => {
        console.log(err);
      })
  }

  getLangues(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.lngs = data;

        this.dllng = [];
        for (let s of this.lngs) {
          this.dllng.push(s.langue);
        }

      }, err => {
        console.log(err);
      })
  }

  getSocietes(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.societes = data;

        this.dlsociete = [];
        for (let s of this.societes) {
          this.dlsociete.push(s.nomSociete);
        }

      }, err => {
        console.log(err);
      })
  }

  getMCs(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.mcs = data;

        this.dlmc = [];
        for (let s of this.mcs) {
          this.dlmc.push(s);
        }

      }, err => {
        console.log(err);
      })
  }

  profil: AddProfilComponent["Profil"] = new Profil("", "", "", "", "", "", "", "", "", "", "", "", "", "");

  createProfilFormation(p) {
    this.service.createRessources("/admin/saveProfil", p)
      .subscribe(data => {
        alert("Profil  added successfully.");
        this.getCurrentProfil();
        this.uploadPhoto(p);

      });
  };

  selectedFiles;
  progress = 0;
  currentFileUpload;
  onSelectFile(event) {
    this.selectedFiles = event.target.files;
  }
  uploadPhoto(p) {

    this.currentFileUpload = this.selectedFiles.item(0);
    const formData = new FormData();

    formData.append('file', this.currentFileUpload);
    this.service.createRessources("/admin/savePhoto", formData)
      .subscribe(data => {
        alert("Fin de téléchargement");


      }, err => {
        alert("Probleme de chargement");
      })

    this.selectedFiles = undefined
  }


  getCurrentProfil(): void {
    this.service.getRessources("/profilEnregistrer")
      .subscribe(data => {
        this.codeProfil = data;
        console.log(this.codeProfil);
        this.getFormations("/profil/" + this.codeProfil + "/formations");
        this.createCv(new CV("", "", "", "", ""));
      }, err => {
        console.log(err);
      });
  };

  getFormations(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.formations = data;

      }, err => {
        console.log(err);
      })
  }

  cv: CV = new CV("", "", "", "", "");
  createCv(cv): void {

    cv.profil = this.codeProfil;
    cv.nomCV = "base" + this.codeProfil;
    console.log(cv);

    this.service.createRessources("/admin/saveCv", cv)
      .subscribe(data => {
        this.getCurrentCV();
      });
  };

  getCurrentCV(): void {
    this.service.getRessources("/cvEnregistrer")
      .subscribe(data => {
        this.codeCV = data;
        console.log(this.codeCV);
        this.getExperiences("/cv/" + this.codeCV + "/experiences");
      }, err => {
        console.log(err);
      });
  };

  formation: Formation = new Formation("", "", "", "", "", "", "", "");

  createFormation(formation): void {

    formation.profil = this.codeProfil;

    console.log(formation);

    this.service.createRessources("/admin/saveFormationProfil", formation)
      .subscribe(data => {

        alert("Formation est ajoutée avec succée");
        this.formations.push(formation);
        //this.router.navigate(['/cv/'+cv.codeCV]);
        //this.getCompetence();
        this.formation.dateDebut = "";
        this.formation.dateFin = "";
        this.formation.details = "";
        this.formation.etablissement = "";
        this.formation.intitule = "";
        this.formation.lieu = "";
        this.formation.profil = "";
      });

    console.log(this.formations);
  };

  exp: Experience = new Experience("", "", "", "", "", "", "", "", "", []);

  createExp(exp): void {

    exp.cv = this.codeCV;
    exp.poste = this.poste;
    exp.societe = this.societe;
    exp.profil = this.codeProfil;

    console.log(exp);

    this.service.createRessources("/admin/saveExperienceCV", exp)
      .subscribe(data => {

        alert("Expérience est ajoutée avec succée");
        this.experiences.push(exp);

        this.exp.dateDebut = "";
        this.exp.dateFin = "";
        this.exp.departement = "";
        this.exp.descriptionRole = "";
        this.exp.poste = "";
        this.exp.societe = "";
        this.exp.profil = "";
      });
  };

  
  comp: CompetenceCV = new CompetenceCV("", "", "", "");

  createComp(comp): void {

    comp.cv = this.codeCV;
    comp.competence = this.comp;

    console.log(comp);

    this.service.createRessources("/admin/saveCompetenceCV", comp)
      .subscribe(data => {

        alert("Competence est ajoutée avec succée");
        this.selectedComps.push(comp);
        console.log("this.selectedComps");
        console.log(this.selectedComps);

        //this.router.navigate(['/cv/'+cv.codeCV]);
        //this.getCompetence();
      });

  };

  lng: LngCV = new LngCV("", "", "", "");

  createLng(lng): void {

    lng.cv = this.codeCV;
    lng.lng = this.lng;

    console.log(lng);

    this.service.createRessources("/admin/saveLangueCV", lng)
      .subscribe(data => {

        alert("Langue est ajoutée avec succée");
        this.selectedLngs.push(lng);

      });

  };

  getExperiences(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.experiences = data;
      }, err => {
        console.log(err);
      })
  }

  onISposte(item: any) {
    for (let p of this.postes) {
      if (p.libellePost == item)
        this.poste = p.codePost;
    }
  }

  onISsociete(item: any) {
    for (let s of this.societes) {
      if (s.nomSociete == item)
        this.societe = s.codeSociete;
    }
  }

  onISmc_exp(item: any) {
    for (let s of this.mcs) {
      console.log(s);
    }
  }

  onIScomp(item: any) {
    for (let s of this.comps) {
      if (s.nomCompetence == item)
        this.comp = s.codeCompetance;
    }
  }

  onISlng(item: any) {
    for (let s of this.lngs) {
      if (s.langue == item)
        this.lng = s.codeLangue;
    }
  }
}
