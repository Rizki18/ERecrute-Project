import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { UserService, Profil, Formation } from '../services/user.service';
import { Profile } from 'selenium-webdriver/firefox';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  private Profil;
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

  constructor(
    private service: UserService, private router: Router) { }

  ngOnInit(): void {
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
  onItemSelect(item: any) {
    //this.authority = item;
  }

 
  charger() {
    this.service.getRessources("/load")
      .subscribe(data => {
        alert("Profils  added successfully from CSV.");
        this.getProfil();
      });
  };
  getProfil() {
    this.service.getRessources("/profil")
      .subscribe(data => {
        this.Profil = data;

      }, err => {
        console.log(err);
      });
  }

  deleteProfil(profil: Profil): void {

    console.log("/admin/deleteProfil/" + profil.codeProfil);
    this.service.deleteRessources("/admin/deleteProfil/" + profil.codeProfil)
      .subscribe(data => {
        this.Profil = this.Profil.filter(u => u !== profil);
        this.getProfil();
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


