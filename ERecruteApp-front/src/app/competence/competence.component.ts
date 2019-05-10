import { Component, OnInit } from '@angular/core';
import { HttpClientService, Competence } from '../services/http-client.service'
@Component({
  selector: 'app-competence',
  templateUrl: './competence.component.html',
  styleUrls: ['./competence.component.css']
})
export class CompetenceComponent implements OnInit {

  private competences;

  constructor( 
    private service: HttpClientService ){}

  ngOnInit() : void {
    this.getCompetence();
  }

  getCompetence() {
    this.service.getRessources("/Competence")
    .subscribe(data=>{
      this.competences = data;
    },err=>{
      console.log(err);
    });
  }

  deleteCompetence(competence:Competence): void {
    
    console.log("/admin/deleteCompetence/"+ competence.codeCompetance);
    this.service.deleteRessources("/admin/deleteCompetence/"+ competence.codeCompetance)
    .subscribe( data => {
      this.competences = this.competences.filter(u => u !== competence);
    });
  }
  competence: Competence = new Competence("","");
  
  
  createCompetence(p): void {
    
    this.service.createRessources("/admin/saveCompetence",p)
        .subscribe( data => {
          alert("Competence added successfully.");
          this.getCompetence();
        });

    this.competence.nomCompetence='';

    this.competence.codeCompetance='';
    
  };
  editCompetence(p): void {
    
    this.service.createRessources("/admin/saveCompetence",p)
        .subscribe( data => {
          alert("Competence edit successfully.");
          this.getCompetence();
        });
  };

}
