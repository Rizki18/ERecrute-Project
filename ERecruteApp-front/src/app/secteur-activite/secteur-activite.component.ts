import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { UserService, SecteurActivite } from '../services/user.service';

@Component({
  selector: 'app-secteur-activite',
  templateUrl: './secteur-activite.component.html',
  styleUrls: ['./secteur-activite.component.css']
})
export class SecteurActiviteComponent implements OnInit {

  private SecteurActivite;
  mode;

  constructor( 
    private service: UserService, private router:Router ){}

  ngOnInit() : void {
    this.getSecteurActivite();
  }

  getSecteurActivite() {
    this.service.getRessources("/Secteur")
    .subscribe(data=>{
      this.SecteurActivite = data;
    },err=>{
      console.log(err);
    });
  }

  deleteSecteurActivite(secteuractivite:SecteurActivite): void {
    
    console.log("/admin/deleteSecteur/"+ secteuractivite.codeSecteur);
    this.service.deleteRessources("/admin/deleteSecteur/"+ secteuractivite.codeSecteur)
    .subscribe( data => {
      this.SecteurActivite = this.SecteurActivite.filter(u => u !== secteuractivite);
    });
  }
  secteuractivite: SecteurActivite = new SecteurActivite("","");
  
  
  createSecteurActivite(p): void {
    
    this.service.createRessources("/admin/saveSecteur",p)
        .subscribe( data => {
          alert("Secteur d'activite added successfully.");
          this.getSecteurActivite();
        });

    this.secteuractivite.codeSecteur='';

    this.secteuractivite.libelleSecteur='';
    
  };
  
  editSecteurActivite(p): void {
  
    this.mode = p.codeSecteur;
  };
  
  updateSecteurActivite(p): void {
  
    this.mode = -1;

    this.service.createRessources("/admin/saveSecteurActivite",p)
        .subscribe( data => {
          //alert("Secteur d'activite edit successfully.");
          this.getSecteurActivite();
        });

  };

}

