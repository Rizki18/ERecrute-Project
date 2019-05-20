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

  constructor( 
    private service: UserService, private router:Router ){}
    
  ngOnInit() : void {
      
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
