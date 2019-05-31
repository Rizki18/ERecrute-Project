import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService,Poste } from '../services/user.service';

@Component({
  selector: 'app-poste',
  templateUrl: './poste.component.html',
  styleUrls: ['./poste.component.css']
})
export class PosteComponent implements OnInit {

  private postes;
  mode;

  constructor( 
    private service: UserService, private router:Router ){}

  ngOnInit() : void {
    this.getPoste();
  }

  getPoste() {
    this.service.getRessources("/Poste")
    .subscribe(data=>{
      this.postes = data;
      alert("poste retreive");
    },err=>{
      console.log(err);
    });
  }

  deletePoste(poste:Poste): void {
    
    console.log("/admin/deletePoste/"+ poste.codePost);
    this.service.deleteRessources("/admin/deletePoste/"+ poste.codePost)
    .subscribe( data => {
      this.postes = this.postes.filter(u => u !== poste);
    });
  }
  poste: Poste = new Poste("","","");
  
  
  createPoste(p): void {
    
    this.service.createRessources("/admin/savePoste",p)
        .subscribe( data => {
          alert("Poste added successfully.");
          this.getPoste();
        });

    this.poste.codePost=" ";
    this.poste.descriptionPoste=" ";
    this.poste.libellePost=" ";
    
  };
  
  editPoste(p): void {
  
    this.mode = p.codePost;
  };
  
  updatePoste(p): void {
  
    this.mode = -1;

    this.service.createRessources("/admin/savePoste",p)
        .subscribe( data => {
          //alert("Competence edit successfully.");
          this.getPoste();
        });

  };

}
