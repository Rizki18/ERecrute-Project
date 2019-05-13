import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { Router } from '@angular/router'

=======
>>>>>>> 9329eeca1c67666855b833434876047bfc34fab6
import { UserService, Competence } from '../services/user.service';

@Component({
  selector: 'app-competence',
  templateUrl: './competence.component.html',
  styleUrls: ['./competence.component.css']
})
export class CompetenceComponent implements OnInit {

  private competences;
<<<<<<< HEAD
  mode;

  constructor( 
    private service: UserService, private router:Router ){}
=======

  constructor( 
    private service: UserService ){}
>>>>>>> 9329eeca1c67666855b833434876047bfc34fab6

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
<<<<<<< HEAD
  
  editCompetence(p): void {
  
    this.mode = p.codeCompetance;
  };
  
  updateCompetence(p): void {
  
=======
  editCompetence(p): void {
    
>>>>>>> 9329eeca1c67666855b833434876047bfc34fab6
    this.service.createRessources("/admin/saveCompetence",p)
        .subscribe( data => {
          alert("Competence edit successfully.");
          this.getCompetence();
        });
<<<<<<< HEAD

        this.router.navigate(['/edit-user']);
=======
>>>>>>> 9329eeca1c67666855b833434876047bfc34fab6
  };

}
