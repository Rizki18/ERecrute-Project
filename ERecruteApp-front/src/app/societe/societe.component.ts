import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService,Societe } from '../services/user.service';

@Component({
  selector: 'app-societe',
  templateUrl: './societe.component.html',
  styleUrls: ['./societe.component.css']
})
export class SocieteComponent implements OnInit {
  private societes;
  mode;

  constructor( 
    private service: UserService, private router:Router ){}

  ngOnInit() : void {
    this.getSociete();
  }

  getSociete() {
    this.service.getRessources("/Societe")
    .subscribe(data=>{
      this.societes = data;
      //alert("poste retreive");
    },err=>{
      console.log(err);
    });
  }

  deleteSociete(societe:Societe): void {
    
    console.log("/admin/deletePoste/"+ societe.codeSociete);
    this.service.deleteRessources("/admin/deletePoste/"+ societe.codeSociete)
    .subscribe( data => {
      this.societes = this.societes.filter(u => u !== societe);
    });
  }
  societe: Societe = new Societe("","");
  
  
  createSociete(p): void {
    
    this.service.createRessources("/admin/saveSociete",p)
        .subscribe( data => {
          //alert("Poste added successfully.");
          this.getSociete();
        });

    this.societe.codeSociete=" ";
    this.societe.nomSociete=" ";
    
  };
  
  editSociete(p): void {
  
    this.mode = p.codeSociete;
  };
  
  updateSociete(p): void {
  
    this.mode = -1;

    this.service.createRessources("/admin/saveSociete",p)
        .subscribe( data => {
          //alert("Competence edit successfully.");
          this.getSociete();
        });

  };

}

