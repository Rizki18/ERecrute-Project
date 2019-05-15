import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { UserService, TypeContrat } from '../services/user.service';

@Component({
  selector: 'app-type-contrat',
  templateUrl: './type-contrat.component.html',
  styleUrls: ['./type-contrat.component.css']
})
export class TypeContratComponent implements OnInit {

  private TypeContrat;
  mode;

  constructor( 
    private service: UserService, private router:Router ){}

  ngOnInit() : void {
    this.getTypeContrat();
  }

  getTypeContrat() {
    this.service.getRessources("/TypeContrat")
    .subscribe(data=>{
      this.TypeContrat = data;
    },err=>{
      console.log(err);
    });
  }

  deleteTypeContrat(typecontrat:TypeContrat): void {
    
    console.log("/admin/deleteTypeContrat/"+ typecontrat.codeTypeContrat);
    this.service.deleteRessources("/admin/deleteTypeContrat/"+ typecontrat.codeTypeContrat)
    .subscribe( data => {
      this.TypeContrat = this.TypeContrat.filter(u => u !== typecontrat);
    });
  }
  typecontrat: TypeContrat = new TypeContrat("","");
  
  
  createTypeContrat(p): void {
    
    this.service.createRessources("/admin/saveTypeContrat",p)
        .subscribe( data => {
          alert("Type Contrat added successfully.");
          this.getTypeContrat();
        });

    this.typecontrat.codeTypeContrat='';

    this.typecontrat.libelleContrat='';
    
  };
  
  editTypeContrat(p): void {
  
    this.mode = p.codeTypeContrat;
  };
  
  updateTypeContrat(p): void {
  
    this.mode = -1;

    this.service.createRessources("/admin/saveTypeContrat",p)
        .subscribe( data => {
          //alert("Type Contrat edit successfully.");
          this.getTypeContrat();
        });

  };

}


