import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient, HttpRequest, HttpEvent,HttpResponse} from '@angular/common/http';
import { UserService, Profil, Formation } from '../services/user.service';
@Component({
  selector: 'app-add-profil',
  templateUrl: './add-profil.component.html',
  styleUrls: ['./add-profil.component.css']
})

export class AddProfilComponent implements OnInit {

  private Profil ;
  private Formation;
  competences ;dlcompetence ;sIcompetence = [];
  langues ;dllangue ;sIlangue = [];
  secteurActivite ;dlsecteurActivite ;sIsecteurActivite = [];
  situationFamiliale ;dlsituationFamiliale ;sIsituationFamiliale = [];
  TypeContact ;dltypeContrat ;sItypeContact = [];
  TypeProfil ;dltypeProfil ;sItypeProfil = [];
  dropdownSettings = {};

  constructor( 
    private service: UserService, private router:Router ){}
  ngOnInit() : void {
        this.dropdownSettings = {
      singleSelection: false,
      itemsShowLimit: 5,
      allowSearchFilter: true
    };
    
    this.service.getRessources("/CompetenceName")
    .subscribe(data=>{
          this.dlcompetence= data;
    },err=>{
      console.log(err);
    }); 
    this.service.getRessources("/LangueName")
    .subscribe(data=>{
          this.dllangue = data;
    },err=>{
      console.log(err);
    });
    this.service.getRessources("/SecteurName")
    .subscribe(data=>{
          this.dlsecteurActivite = data;
    },err=>{
      console.log(err);
    });
    this.service.getRessources("/SituationFamilialeName")
    .subscribe(data=>{
          this.dlsituationFamiliale = data;
          console.log(this.dlsituationFamiliale);
    },err=>{
      console.log(err);
    });
    this.service.getRessources("/TypeContratName")
    .subscribe(data=>{
          this.dltypeContrat = data;
    },err=>{
      console.log(err);
    });    
    this.service.getRessources("/TypeProfilName")
    .subscribe(data=>{
          this.dltypeProfil = data;
    },err=>{
      console.log(err);
    });       
    }
    onItemSelect(item: any) {
      //this.authority = item;
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
   /*SelectedFile = null;
  onFileSelected(event)
  {
    this.SelectedFile=<File> event.traget.files[0];
  }
 onUpload()
  {
    const fd = new FormData();
    fd.append('image',this.SelectedFile,this.SelectedFile.name);
    this.service.post("savephoto",fd)
        .subscribe(res => {
          console.log(res);
         } );
  }
  pushFileToStorage(file: File) {
    let formdata: FormData = new FormData();
 
    formdata.append('file', file);
 
    
    return this.service.createRessources("/postfile",formdata);
  }
  currentFileUpload;
  upload()
  {
    this.currentFileUpload = this.SelectedFile.item(0)
    this.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      (event instanceof HttpResponse); {
        console.log('File is completely uploaded!'),
        alert("ilage added successfully");
      }
    });
  }
  */
}
