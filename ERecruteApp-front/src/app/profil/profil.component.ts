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

  private Profil ;
  private Formation;

  constructor( 
    private service: UserService, private router:Router ){}
    
  ngOnInit() : void {
      this.getProfil();
    }
  
  profil: ProfilComponent["Profil"] = new Profil("","","","","","","","","","","","","","");
  
  createProfil(p): void {
    this.service.createRessources("/admin/saveProfil",p)
        .subscribe( data => {
          alert("Profil added successfully.");
        }); 
  };
  createProfilFormation(p)
  {
    this.service.createRessources("/admin/saveProfil",p)
        .subscribe( data => {
          alert("Profil  added successfully.");
          this.createFormation(p);
        });
  };
  formation: ProfilComponent["Formation"] = new Formation("","","","","","","","");
  
  createFormation(p): void {
      this.service.createRessources("/admin/saveFormation",p)
        .subscribe( data => {
          alert("formation added successfully.");
         // this.getFormation();
        });
    
  };
 
    getProfil() {
    this.service.getRessources("/profil")
    .subscribe(data=>{
      this.Profil = data;
      alert("test");
    },err=>{
      console.log(err);
    });
  }  
  /*
  deleteProfil(profil:Profil): void {
  
    console.log("/admin/deleteProfil/"+ profil.codeProfil);
    this.service.deleteRessources("/admin/deleteProfil/"+ profil.codeProfil)
    .subscribe( data => {
      this.Profil = this.Profil.filter(u => u !== profil);
    });
  }
  editProfil(p): void {
  
    this.mode = p.codeProfil;
  };
  
  updateProfil(p): void {
  
    this.mode = -1;

    this.service.createRessources("/admin/saveProfil",p)
        .subscribe( data => {
          //alert("Profil edit successfully.");
          this.getProfil();
        });

  };
  */

}


