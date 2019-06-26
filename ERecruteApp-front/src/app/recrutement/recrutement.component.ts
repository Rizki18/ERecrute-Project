import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { UserService, Profil, Experience } from '../services/user.service';

@Component({
  selector: 'app-recrutement',
  templateUrl: './recrutement.component.html',
  styleUrls: ['./recrutement.component.css']
})
export class RecrutementComponent implements OnInit {

  private Profil ;
  private Poste ;
  private Societe ;
  private Experience;
  
    
    postes;dlposte; sIposte;
  dlsociete;dlprofil;  societes;
  comps; Exp;
 // private Profil;
  private Formation;
  recherche = -1;
  rechercheRes = -1;

  competences; dlcompetence; sIcompetence = [];
  langues; dllangue; sIlangue = [];
  secteurActivite; dlsecteurActivite; sIsecteurActivite = [];
  situationFamiliale; dlsituationFamiliale; sIsituationFamiliale = [];
  TypeContact; dltypeContrat; sItypeContact = [];
  TypeProfil; dltypeProfil; sItypeProfil = [];
  dropdownSettings = {};

  dlposte; dlsociete; dlmc;
  postes; societes;  poste; societe; mcs; sImc_exp; sIposte; sIsociete;
  dropdownSettingsSingle = {};

  constructor(
    private service: UserService, private router: Router) { }

  ngOnInit(): void {
    this.getPostes("/postes");
    this.getSocietes("/societes");
    this.getMCs("/MotclesName");

    this.getProfil();
    this.dropdownSettings = {
      singleSelection: false,
      itemsShowLimit: 5,
      allowSearchFilter: true
    };

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

  onItemSelect(item: any) {
    //this.authority = item;
  }

  getProfil() {
    this.service.getRessources("/profil")
      .subscribe(data => {
        this.Profil = data;

      }, err => {
        console.log(err);
      });
  }

  rechercher() {
    if (this.recherche == -1)
      this.recherche = 1;
    else
      this.recherche = -1;
  }

  effectuerRechercheS(){
    this.rechercheRes = 2;
  }

  effectuerRechercheA(){
    this.rechercheRes = 3;
  }
}
