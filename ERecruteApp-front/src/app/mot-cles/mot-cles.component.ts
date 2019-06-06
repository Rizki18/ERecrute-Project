import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService, Motcles } from '../services/user.service';
@Component({
  selector: 'app-mot-cles',
  templateUrl: './mot-cles.component.html',
  styleUrls: ['./mot-cles.component.css']
})

export class MotClesComponent implements OnInit {

  private motcles;
  mode;

  constructor( 
    private service: UserService, private router:Router ){}

  ngOnInit() : void {
    this.getMotcles();
  }

  getMotcles() {
    this.service.getRessources("/Motcles")
    .subscribe(data=>{
      this.motcles = data;
    },err=>{
      console.log(err);
    });
  }

  deleteMotcles(motcless:Motcles): void {
    
    console.log("/admin/deleteMotcles/"+ motcless.codeMotCle);
    this.service.deleteRessources("/admin/deleteMotcles/"+ motcless.codeMotCle)
    .subscribe( data => {
      this.motcles = this.motcles.filter(u => u !== motcless);
    });
  }
    motcle: Motcles = new Motcles("","");
  
  
  createMotcles(p): void {
    
    this.service.createRessources("/admin/saveMotcles",p)
        .subscribe( data => {
          alert("Mot cle added successfully.");
          console.log(data);
          this.getMotcles();
        });

        this.motcle.codeMotCle='';
        this.motcle.libelleMotCle='';
    
  };
  
  editMotcles(p): void {
  
    this.mode = p.codeMotCle;
  };
  
  updateMotcles(p): void {
  
    this.mode = -1;

    this.service.createRessources("/admin/saveMotcles",p)
        .subscribe( data => {
          //alert("Langue edit successfully.");
          this.getMotcles();
        });

  };

}
