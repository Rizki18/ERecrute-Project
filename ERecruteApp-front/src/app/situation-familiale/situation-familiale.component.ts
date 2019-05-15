import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { UserService, SituationFamiliale } from '../services/user.service';

@Component({
  selector: 'app-situation-familiale',
  templateUrl: './situation-familiale.component.html',
  styleUrls: ['./situation-familiale.component.css']
})
export class SituationFamilialeComponent implements OnInit {

  private SituationFamiliale;
  mode;

  constructor( 
    private service: UserService, private router:Router ){}

  ngOnInit() : void {
    this.getSituationFamiliale();
  }

  getSituationFamiliale() {
    this.service.getRessources("/SituationFamiliale")
    .subscribe(data=>{
      this.SituationFamiliale = data;
    },err=>{
      console.log(err);
    });
  }

  deleteSituationFamiliale(situationfamiliale:SituationFamiliale): void {
    
    console.log("/admin/deleteSituationFamiliale/"+ situationfamiliale.codeSituationFamiliale);
    this.service.deleteRessources("/admin/deleteSituationFamiliale/"+ situationfamiliale.codeSituationFamiliale)
    .subscribe( data => {
      this.SituationFamiliale = this.SituationFamiliale.filter(u => u !== situationfamiliale);
    });
  }
  situationfamiliale: SituationFamiliale = new SituationFamiliale("","");
  
  
  createSituationFamiliale(p): void {
    
    this.service.createRessources("/admin/saveSituationFamiliale",p)
        .subscribe( data => {
          alert("Situation Familiale added successfully.");
          this.getSituationFamiliale();
        });

    this.situationfamiliale.codeSituationFamiliale='';

    this.situationfamiliale.civilite='';
    
  };
  
  editSituationFamiliale(p): void {
  
    this.mode = p.codeSituationFamiliale;
  };
  
  updateSituationFamiliale(p): void {
  
    this.mode = -1;

    this.service.createRessources("/admin/saveSituationFamiliale",p)
        .subscribe( data => {
          //alert("Situation Familiale edit successfully.");
          this.getSituationFamiliale();
        });

  };

}

