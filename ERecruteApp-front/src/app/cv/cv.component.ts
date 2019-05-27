import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService, Formation  } from '../services/user.service';

import * as jspdf from 'jspdf';  
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {

  profil;
  cv;
  Formation;
  formations;
  experiences;
  tmp;selectedFormations = [];

  dlformation ;sIformation = [];
  dropdownSettings = {};

  mode = -1;


  constructor( private service: UserService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.getCV("/cv/"+params['id']);
      
    });

    this.dropdownSettings = {
      singleSelection: false,
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

  }

  getCV(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.cv = data;
      console.log(this.cv);

      this.getFormations("/profil/"+this.cv.profil.codeProfil+"/formations");

      this.getExperiences("/cv/"+this.cv.codeCV+"/experiences")
    },err=>{
      console.log(err);
    })
  }

  getFormations(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.formations = data;
      this.selectedFormations = this.formations;
      
      this.dlformation = [];
      this.sIformation = [];
      for(let el of this.formations){
        this.dlformation.push(el.intitule);
        this.sIformation.push(el.intitule);
      }
      
    },err=>{
      console.log(err);
    })
  }

  getExperiences(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.experiences = data;
      console.log(this.experiences);
      //this.selectedFormations = this.formations;
      
      //this.dlformation = [];
      //this.sIformation = [];
      //for(let el of this.formations){
      //  this.dlformation.push(el.intitule);
      //  this.sIformation.push(el.intitule);
      //}
      
    },err=>{
      console.log(err);
    })
  }

 
  onIS(item: any) {
    for(let el of this.formations){
      if(el.intitule == item)
        this.selectedFormations.push(el);
    }
      
    console.log(this.selectedFormations);
  }

  onIDS(item: any) {
    this.tmp = [];
    for(let el of this.selectedFormations){
      if(el.intitule != item)
        this.tmp.push(el);
    }

    this.selectedFormations = this.tmp;
      
    console.log(this.selectedFormations);
  }

  formation: Formation = new Formation("","","","","","","","");
  
  createFormation(formation): void {
  
    formation.profil = this.cv.profil.codeProfil;

    console.log(formation);

    this.service.createRessources("/admin/saveFormationProfil",formation)
        .subscribe( data => {
          
          alert("Formation est ajoutée avec succée");
          this.formations.push(formation);
          this.dlformation.push(formation.intitule);
          //this.router.navigate(['/cv/'+cv.codeCV]);
          //this.getCompetence();
        });

        console.log(this.formations);
  };

  addFormation(){
    this.mode = 1;
  }

  public captureScreen()  
  {  
    var data = document.getElementById('cv');  
    html2canvas(data).then(canvas => {  
      // Few necessary setting options  
      var imgWidth = 208;   
      var pageHeight = 295;    
      var imgHeight = canvas.height * imgWidth / canvas.width;  
      var heightLeft = imgHeight;  
  
      const contentDataURL = canvas.toDataURL('image/png')  
      let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF  
      var position = 0;  
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)  
      pdf.save('CV.pdf'); // Generated PDF   
    });  
  }

}
