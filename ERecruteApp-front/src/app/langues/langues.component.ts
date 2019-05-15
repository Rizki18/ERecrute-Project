import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { UserService, Langues } from '../services/user.service';
@Component({
  selector: 'app-langues',
  templateUrl: './langues.component.html',
  styleUrls: ['./langues.component.css']
})
export class LanguesComponent implements OnInit {

  private langues;
  mode;

  constructor( 
    private service: UserService, private router:Router ){}

  ngOnInit() : void {
    this.getLangues();
  }

  getLangues() {
    this.service.getRessources("/Langues")
    .subscribe(data=>{
      this.langues = data;
    },err=>{
      console.log(err);
    });
  }

  deleteLangues(langue:Langues): void {
    
    console.log("/admin/deleteLangues/"+ langue.codeLangue);
    this.service.deleteRessources("/admin/deleteLangues/"+ langue.codeLangue)
    .subscribe( data => {
      this.langues = this.langues.filter(u => u !== langue);
    });
  }
  langue: Langues = new Langues("","");
  
  
  createLangues(p): void {
    
    this.service.createRessources("/admin/saveLangues",p)
        .subscribe( data => {
          alert("Langue added successfully.");
          this.getLangues();
        });

    this.langue.langue='';

    this.langue.codeLangue='';
    
  };
  
  editLangues(p): void {
  
    this.mode = p.codeLangue;
  };
  
  updateLangues(p): void {
  
    this.mode = -1;

    this.service.createRessources("/admin/saveLangues",p)
        .subscribe( data => {
          //alert("Langue edit successfully.");
          this.getLangues();
        });

  };

}
