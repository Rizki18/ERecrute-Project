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
  
  constructor( 
    private service: UserService, private router:Router ){}
    
    postes;dlposte; sIposte;
  dlsociete;dlprofil;  societes;
  comps; Exp;
  dropdownSettings = {};
  dropdownSettingsSingle = {};
  ngOnInit() : void {
    this.getPostes("/postes");
    }
    getProfil() {
      this.service.getRessources("/profil")
      .subscribe(data=>{
        this.Profil = data;
       
      },err=>{
        console.log(err);
      });
    }  
    getPostes(url) {
      this.service.getRessources(url)
        .subscribe(data => {
          this.Poste = data;
  
          this.dlposte = [];
          for (let p of this.Poste) {
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
  
    
  
  onISposte(item: any) {
    for (let p of this.Poste) {
      if (p.libellePost == item.Poste)
        this.Poste = p.codePost;
    }
  }

  onISsociete(item: any) {
    for (let s of this.Societe) {
      if (s.nomSociete == item)
        this.Societe = s.codeSociete;
    }
  }
  onISprofil(item: any) {
    for (let s of this.Profil) {
      if (s.nom == item)
        this.Profil = s.codeProfil;
    }
  }
}
