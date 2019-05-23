import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { UserService, Profil, Formation } from '../services/user.service';
@Component({
  selector: 'app-add-profil',
  templateUrl: './add-profil.component.html',
  styleUrls: ['./add-profil.component.css']
})
export class AddProfilComponent implements OnInit {

  private Profil ;
  private Formation;
  competences ;dlcompetence ;sIcompetence = [];
  langues ;dllangue ;sIlangue = [];
  secteurActivite ;dlsecteurActivite ;sIsecteurActivite = [];
  situationFamiliale ;dlsituationFamiliale ;sIsituationFamiliale = [];
  TypeContact ;dltypeContact ;sItypeContact = [];
  TypeProfil ;dltypeProfil ;sItypeProfil = [];
  dropdownSettings = {};

  constructor( 
    private service: UserService, private router:Router ){}
  ngOnInit() : void {
        this.dropdownSettings = {
      singleSelection: false,
      itemsShowLimit: 5,
      allowSearchFilter: true
    };
    
    this.service.getRessources("/CompetenceName")
    .subscribe(data=>{
          this.dlcompetence= data;
    },err=>{
      console.log(err);
    }); 
    this.service.getRessources("/LangueName")
    .subscribe(data=>{
          this.dllangue = data;
    },err=>{
      console.log(err);
    });
    this.service.getRessources("/Secteurame")
    .subscribe(data=>{
          this.dlsecteurActivite = data;
    },err=>{
      console.log(err);
    });
    this.service.getRessources("/SituationFamilialeName")
    .subscribe(data=>{
          this.dlsituationFamiliale = data;
    },err=>{
      console.log(err);
    });
    this.service.getRessources("/TypeContractName")
    .subscribe(data=>{
          this.dltypeContact = data;
    },err=>{
      console.log(err);
    });    
    this.service.getRessources("/TypeProfilName")
    .subscribe(data=>{
          this.dltypeProfil = data;
    },err=>{
      console.log(err);
    });       
    }
    onItemSelect(item: any) {
      //this.authority = item;
    }
  profil: AddProfilComponent["Profil"] = new Profil("","","","","","","","","","","","","","");
  
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
  formation: AddProfilComponent["Formation"] = new Formation("","","","","","","","");
  
  createFormation(p): void {
      this.service.createRessources("/admin/saveFormation",p)
        .subscribe( data => {
          alert("formation added successfully.");
         // this.getFormation();
        });
    
  };
 
  
}
