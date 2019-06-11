import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService, Formation, Experience, CompetenceCV, LngCV, SaCV, SfCV, TpCV, TcCV }
  from '../services/user.service';

import * as jspdf from 'jspdf';
import html2canvas from 'html2canvas';
import { HttpEventType, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {

  editPhoto = 0;
  selectedFiles;
  progress = 0;
  currentFileUpload;

  profil;
  cv;
  Formation;
  formations;
  experiences;
  postes; societes;
  comps; lngs; sas; sfs; tps; tcs;
  poste; societe;
  tmp; selectedFormations = []; selectedExps;
  selectedComps; selectedLngs; selectedSas; selectedSfs; selectedTps; selectedTcs;
  selectedSf;
  dlformation; sIformation = [];
  dlexp; sIexp = [];
  dlcompetence; sIcompetence = []; dlLNG; siLNG = []; dlSA; siSA = []; dlSF; siSF = []; dlTP; siTP = []; dlTC; siTC = [];
  sIposte; sIsociete;
  sIcomp; dlcomp; sIlng; dllng; sIsa; dlsa; sIsf; dlsf; sItp; dltp; sItc; dltc;
  dlposte; dlsociete;
  dropdownSettings = {};
  dropdownSettingsSingle = {};

  modeExp;


  constructor(private service: UserService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.getCV("/cv/" + params['id']);

    });

    this.dropdownSettings = {
      singleSelection: false,
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

    this.dropdownSettingsSingle = {
      singleSelection: true,
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

  }

  getCV(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.cv = data;
        console.log(this.cv);

        this.getFormations("/profil/" + this.cv.profil.codeProfil + "/formations");
        this.getExperiences("/cv/" + this.cv.codeCV + "/experiences");
        this.getExperiencesProfil("/profil/" + this.cv.profil.codeProfil + "/experiences");

        this.getPostes("/postes");
        this.getSocietes("/societes");
        this.getCompetences("/Competence");
        this.getLangues("/Langues");
        this.getSecteurs("/Secteur");
        this.getSituations("/SituationFamiliale");
        this.getTypeContrats("/TypeContrat");
        this.getTypeProfils("/TypeProfil");
        this.getCompetencesCV("/cv/" + this.cv.codeCV + "/competences");
        this.getLanguesCV("/cv/" + this.cv.codeCV + "/langues");
        this.getSecteursCV("/cv/" + this.cv.codeCV + "/sas");
        this.getSituationsCV("/cv/" + this.cv.codeCV + "/sfs");
        this.getTypeContratsCV("/cv/" + this.cv.codeCV + "/tps");
        this.getTypeProfilsCV("/cv/" + this.cv.codeCV + "/tcs");
      }, err => {
        console.log(err);
      })
  }

  getFormations(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.formations = data;
        this.selectedFormations = this.formations;

        this.dlformation = [];
        this.sIformation = [];
        for (let el of this.formations) {
          this.dlformation.push(el.intitule);
          this.sIformation.push(el.intitule);
        }

      }, err => {
        console.log(err);
      })
  }

  getExperiencesProfil(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.experiences = data;

        console.log(this.experiences);

        this.dlexp = [];
        for (let el of this.experiences) {
          this.dlexp.push(el.descriptionRole);
        }

      }, err => {
        console.log(err);
      })
  }

  getExperiences(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.selectedExps = data;

        this.sIexp = [];
        for (let el of this.selectedExps) {
          this.sIexp.push(el.descriptionRole);
        }

      }, err => {
        console.log(err);
      })
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

  getCompetencesCV(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.selectedComps = data;
        console.log("****** COMPETENCES");
        console.log(this.selectedComps);

        this.sIcompetence = [];
        for (let el of this.selectedComps) {
          this.sIcompetence.push(el.nom);
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

  getLanguesCV(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.selectedLngs = data;

        this.siLNG = [];
        for (let el of this.selectedLngs) {
          this.siLNG.push(el.nom);
        }
      }, err => {
        console.log(err);
      })
  }

  getSecteurs(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.sas = data;

        this.dlsa = [];
        for (let s of this.lngs) {
          this.dlsa.push(s.libelleSecteur);
        }

      }, err => {
        console.log(err);
      })
  }

  getSecteursCV(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.selectedSas = data;

        this.siSA = [];
        for (let el of this.selectedSas) {
          this.siSA.push(el.nom);
        }
      }, err => {
        console.log(err);
      })
  }

  getSituations(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.sfs = data;

        this.dlsf = [];
        for (let s of this.sfs) {
          this.dlsf.push(s.civilite);
        }

      }, err => {
        console.log(err);
      })
  }

  getSituationsCV(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.selectedSfs = data;
        this.selectedSf = this.selectedSfs[0]; 

        console.log(this.selectedSfs[0]);

        this.siSF = [];
        for (let el of this.selectedSfs) {
          this.siSF.push(el.nom);
        }
      }, err => {
        console.log(err);
      })
  }

  getTypeContrats(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.tcs = data;

        this.dltc = [];
        for (let s of this.tcs) {
          this.dltc.push(s.libelleContrat);
        }

      }, err => {
        console.log(err);
      })
  }

  getTypeContratsCV(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.selectedTcs = data;

        this.siTC = [];
        for (let el of this.selectedTcs) {
          this.siTC.push(el.nom);
        }
      }, err => {
        console.log(err);
      })
  }

  getTypeProfils(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.tps = data;

        this.dltp = [];
        for (let s of this.tps) {
          this.dltp.push(s.libelleProfil);
        }

      }, err => {
        console.log(err);
      })
  }

  getTypeProfilsCV(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.selectedTps = data;

        this.siTP = [];
        for (let el of this.selectedTps) {
          this.siTP.push(el.nom);
        }
      }, err => {
        console.log(err);
      })
  }

  onIS(item: any) {
    for (let el of this.formations) {
      if (el.intitule == item)
        this.selectedFormations.push(el);
    }
    this.sIformation = [];
    for (let el of this.selectedFormations) {
      this.sIexp.push(el.intitule);
    }

  }

  onIDS(item: any) {
    this.tmp = [];
    for (let el of this.selectedFormations) {
      if (el.intitule != item)
        this.tmp.push(el);
    }

    this.selectedFormations = this.tmp;

    console.log(this.selectedFormations);
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

  onISsa(item: any) {
    for (let s of this.sas) {
      if (s.libelleSecteur == item)
        this.sa = s.codeSecteur;
    }
  }

  onISsf(item: any) {
    for (let s of this.sfs) {
      if (s.civilite == item)
        this.sf = s.codeSituationFamiliale;
    }
  }

  onIStc(item: any) {
    for (let s of this.tcs) {
      if (s.libelleContrat == item)
        this.tc = s.codeTypeContrat;
    }
  }

  onIStp(item: any) {
    for (let s of this.tps) {
      if (s.libelleProfil == item)
        this.tp = s.codeTypeProfil;
    }
  }

  onISexp(item: any) {
    for (let el of this.experiences) {
      if (el.descriptionRole == item)
        this.selectedExps.push(el);
    }

  }

  onIDScompetence(item: any) {
    this.tmp = [];
    for (let el of this.selectedComps) {
      if (el.nom != item)
        this.tmp.push(el);
    }

    this.selectedComps = this.tmp;

    console.log(this.selectedExps);
  }

  onIScompetence(item: any) {
    for (let el of this.selectedComps) {
      if (el.nom == item)
        this.selectedComps.push(el);
    }

  }

  onIDSexp(item: any) {
    this.tmp = [];
    for (let el of this.selectedExps) {
      if (el.descriptionRole != item)
        this.tmp.push(el);
    }

    this.selectedExps = this.tmp;

    console.log(this.selectedExps);
  }

  formation: Formation = new Formation("", "", "", "", "", "", "", "");

  createFormation(formation): void {

    formation.profil = this.cv.profil.codeProfil;

    console.log(formation);

    this.service.createRessources("/admin/saveFormationProfil", formation)
      .subscribe(data => {

        alert("Formation est ajoutée avec succée");
        this.formations.push(formation);
        this.dlformation.push(formation.intitule);
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

  exp: Experience = new Experience("", "", "", "", "", "", "", "");

  createExp(exp): void {

    exp.cv = this.cv.codeCV;
    exp.poste = this.poste;
    exp.societe = this.societe;

    console.log(exp);

    this.service.createRessources("/admin/saveExperienceCV", exp)
      .subscribe(data => {

        alert("Expérience est ajoutée avec succée");
        this.experiences.push(exp);
        this.dlexp = [];
        for (let el of this.experiences) {
          this.dlexp.push(el.descriptionRole);
        }
        //this.router.navigate(['/cv/'+cv.codeCV]);
        //this.getCompetence();
        this.exp.dateDebut = "";
        this.exp.dateFin = "";
        this.exp.departement = "";
        this.exp.descriptionRole = "";
        this.exp.poste = "";
        this.exp.societe = "";
      });

    this.getExperiences("/cv/" + this.cv.codeCV + "/experiences");

  };

  addExpToCV(exp): void {

    exp.cv = this.cv.codeCV;
    exp.exp = [];
    for (let el of this.selectedExps) {
      exp.exp.push(el.codeExperience)
    }

    console.log("************");
    console.log(exp);

    this.service.createRessources("/admin/addExperienceToCV", exp)
      .subscribe(data => {

        alert("Expériences est ajoutée au CV avec succée");

        //this.router.navigate(['/cv/'+cv.codeCV]);
        //this.getCompetence();
      });

  };

  addCompToCV(comp): void {

    comp.cv = this.cv.codeCV;
    comp.comp = [];
    for (let el of this.selectedComps) {
      comp.comp.push(el.comp)
    }

    console.log("************");
    console.log(comp);

    this.service.createRessources("/admin/addCompetenceToCV", comp)
      .subscribe(data => {

        alert("competences est ajoutée au CV avec succée");

        //this.router.navigate(['/cv/'+cv.codeCV]);
        //this.getCompetence();
      });

  };

  comp: CompetenceCV = new CompetenceCV("", "", "", "");

  createComp(comp): void {

    comp.cv = this.cv.codeCV;
    comp.competence = this.comp;

    console.log(comp);

    this.service.createRessources("/admin/saveCompetenceCV", comp)
      .subscribe(data => {

        alert("Competence est ajoutée avec succée");
        this.selectedComps.push(comp);

        //this.router.navigate(['/cv/'+cv.codeCV]);
        //this.getCompetence();
      });

  };

  lng: LngCV = new LngCV("", "", "", "");

  createLng(lng): void {

    lng.cv = this.cv.codeCV;
    lng.lng = this.lng;

    console.log(lng);

    this.service.createRessources("/admin/saveLangueCV", lng)
      .subscribe(data => {

        alert("Langue est ajoutée avec succée");
        this.selectedLngs.push(lng);

      });

  };

  sa: SaCV = new SaCV("", "", "", "");

  createSa(sa): void {

    sa.cv = this.cv.codeCV;
    sa.sa = this.sa;

    console.log(sa);

    this.service.createRessources("/admin/saveSaCV", sa)
      .subscribe(data => {

        alert("Secteur d'activité est ajoutée avec succée");
        this.selectedLngs.push(sa);

      });

  };

  sf: SfCV = new SfCV("", "", "", "");

  createSf(sf): void {

    sf.cv = this.cv.codeCV;
    sf.sf = this.sf;

    console.log(sf);

    this.service.createRessources("/admin/saveSfCV", sf)
      .subscribe(data => {

        alert("Situation familiale est ajoutée avec succée");
        this.selectedSfs.push(sf);

      });

  };

  tc: TcCV = new TcCV("", "", "", "");

  createTc(tc): void {

    tc.cv = this.cv.codeCV;
    tc.tc = this.tc;

    console.log(tc);

    this.service.createRessources("/admin/saveTcCV", tc)
      .subscribe(data => {

        alert("Type de contrat est ajouté avec succée");
        this.selectedTcs.push(tc);

      });

  };

  tp: TpCV = new TpCV("", "", "", "");

  createTp(tp): void {

    tp.cv = this.cv.codeCV;
    tp.tc = this.tp;

    console.log(tp);

    this.service.createRessources("/admin/saveTpCV", tp)
      .subscribe(data => {

        alert("Type de profil est ajouté avec succée");
        this.selectedTps.push(tp);

      });

  };

  editExp(exp: Experience): void {
    this.modeExp = exp.codeExperience;
  }

  updateExp(exp): void {

    this.modeExp = -1;
    console.log("Update Experience");
    console.log(exp);
  };

  addExp(): void {

    this.modeExp = 0;
  };

  public captureScreen() {
    var data = document.getElementById('cv');
    html2canvas(data).then(canvas => {
      // Few necessary setting options  
      var imgWidth = 208;
      var pageHeight = 295;
      var imgHeight = canvas.height * imgWidth / canvas.width;
      var heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL('image/png')
      let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF  
      var position = 0;
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)
      pdf.save('CV.pdf'); // Generated PDF   
    });
  }

  blockFormation = 1;
  blockExp = 1;
  blockComp = 1;
  blockLng = 1;

  activerBlock(block) {
    if (block == 1) {
      if (this.blockFormation == 1)
        this.blockFormation = 0;
      else
        this.blockFormation = 1;
    }
    else if (block == 2) {
      if (this.blockExp == 1)
        this.blockExp = 0;
      else
        this.blockExp = 1;
    }
    else if (block == 3) {
      if (this.blockComp == 1)
        this.blockComp = 0;
      else
        this.blockComp = 1;
    }
    else if (block == 4) {
      if (this.blockLng == 1)
        this.blockLng = 0;
      else
        this.blockLng = 1;
    }

  }

  onEditPhoto()
  {
    if(this.editPhoto == 0)
      this.editPhoto = 1;
    else
      this.editPhoto = 0;
  }

  onSelectFile(event)
  {
    this.selectedFiles = event.target.files;
  }

  uploadPhoto()
  {
    this.progress = 0;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.service.uploadPhotoProfil(this.currentFileUpload,this.cv.profil.codeProfil).subscribe(event => {
      if(event.type === HttpEventType.UploadProgress){
        this.progress = Math.round(100 * event.loaded / event.total);
      } else if(event instanceof HttpResponse){
        alert("Fin de téléchargement");
        this.editPhoto = 0;
      }
    },err=>{
      alert("Probleme de chargement");
    })

    this.selectedFiles = undefined
  }

}
