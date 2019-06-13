import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient, HttpRequest, HttpEvent,HttpResponse} from '@angular/common/http';
import { UserService, Profil, Formation, CV } from '../services/user.service';
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

  formations;
  codeProfil;

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
 
  createProfilFormation(p)
  {
    this.service.createRessources("/admin/saveProfil",p)
        .subscribe( data => {
          alert("Profil  added successfully.");
          this.getCurrentProfil();
          
        });
  };


  getCurrentProfil(): void {
    this.service.getRessources("/profilEnregistrer")
    .subscribe(data=>{
          this.codeProfil = data;
          console.log(this.codeProfil);
          this.getFormations("/profil/" + this.codeProfil + "/formations");
          this.createCv(new CV("","","","",""));
    },err=>{
      console.log(err);
    });
  };

  getFormations(url) {
    this.service.getRessources(url)
      .subscribe(data => {
        this.formations = data;

      }, err => {
        console.log(err);
      })
  }

  cv:CV = new CV("","","","","");
  createCv(cv): void {
    
    cv.profil = this.codeProfil;
    cv.nomCV = "base"+this.codeProfil;
    console.log(cv);
    
    this.service.createRessources("/admin/saveCv",cv)
        .subscribe( data => {   
          alert("CV added successfully.");
        });
  };

  formation: Formation = new Formation("", "", "", "", "", "", "", "");

  createFormation(formation): void {

    formation.profil = this.codeProfil;

    console.log(formation);

    this.service.createRessources("/admin/saveFormationProfil", formation)
      .subscribe(data => {

        alert("Formation est ajoutée avec succée");
        this.formations.push(formation);
        //this.router.navigate(['/cv/'+cv.codeCV]);
        //this.getCompetence();
        this.formation.dateDebut = "";
        this.formation.dateFin = "";
        this.formation.details = "";
        this.formation.etablissement = "";
        this.formation.intitule = "";
        this.formation.lieu = "";
        this.formation.profil = "";
      });

    console.log(this.formations);
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
