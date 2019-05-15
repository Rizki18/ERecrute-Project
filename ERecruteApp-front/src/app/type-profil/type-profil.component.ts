import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { UserService, TypeProfil } from '../services/user.service';

@Component({
  selector: 'app-type-profil',
  templateUrl: './type-profil.component.html',
  styleUrls: ['./type-profil.component.css']
})
export class TypeProfilComponent implements OnInit {

  private TypeProfil;
  mode;

  constructor( 
    private service: UserService, private router:Router ){}

  ngOnInit() : void {
    this.getTypeProfil();
  }

  getTypeProfil() {
    this.service.getRessources("/TypeProfil")
    .subscribe(data=>{
      this.TypeProfil = data;
    },err=>{
      console.log(err);
    });
  }

  deleteTypeProfil(typeprofil:TypeProfil): void {
    
    console.log("/admin/deleteTypeProfil/"+ typeprofil.codeTypeProfil);
    this.service.deleteRessources("/admin/deleteTypeProfil/"+ typeprofil.codeTypeProfil)
    .subscribe( data => {
      this.TypeProfil = this.TypeProfil.filter(u => u !== typeprofil);
    });
  }
  typeprofil: TypeProfilComponent["TypeProfil"] = new TypeProfil("","");
  
  
  createTypeProfil(p): void {
    
    this.service.createRessources("/admin/saveTypeProfil",p)
        .subscribe( data => {
          alert("Type Profil added successfully.");
          this.getTypeProfil();
        });

    this.typeprofil.codeTypeProfil='';

    this.typeprofil.libelleProfil='';
    
  };
  
  editTypeProfil(p): void {
  
    this.mode = p.codeTypeProfil;
  };
  
  updateTypeProfil(p): void {
  
    this.mode = -1;

    this.service.createRessources("/admin/saveTypeProfil",p)
        .subscribe( data => {
          //alert("Type Profil edit successfully.");
          this.getTypeProfil();
        });

  };

}


