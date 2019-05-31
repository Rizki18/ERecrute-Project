import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService, Formation, Experience, CompetenceCV  } from '../services/user.service';

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
  postes; societes; comps;
  poste; societe;
  tmp;selectedFormations = [];selectedExps;selectedComps;

  dlformation ;sIformation = [];
  dlexp ;sIexp = [];
  sIposte; sIsociete; sIcomp;
  dlposte ;dlsociete ; dlcomp;
  dropdownSettings = {};
  dropdownSettingsSingle = {};

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

    this.dropdownSettingsSingle = {
      singleSelection: true,
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
      this.getExperiences("/cv/"+this.cv.codeCV+"/experiences");
      this.getExperiencesProfil("/profil/"+this.cv.profil.codeProfil+"/experiences");

      this.getPostes("/postes");
      this.getSocietes("/societes");
      this.getCompetences("/Competence");
      this.getCompetencesCV("/cv/"+this.cv.codeCV+"/competences");
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

  getExperiencesProfil(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.experiences = data;

      console.log(this.experiences);
            
      this.dlexp = [];
      for(let el of this.experiences){
        this.dlexp.push(el.descriptionRole);
      }
      
    },err=>{
      console.log(err);
    })
  }

  getExperiences(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.selectedExps = data;

      this.sIexp = [];
      for(let el of this.selectedExps){
        this.sIexp.push(el.descriptionRole);
      }
      
    },err=>{
      console.log(err);
    })
  }

  getPostes(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.postes = data;
      
      this.dlposte = [];
      for(let p of this.postes){
        this.dlposte.push(p.libellePost);
      }
      
    },err=>{
      console.log(err);
    })
  }

  getSocietes(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.societes = data;
      
      this.dlsociete = [];
      for(let s of this.societes){
        this.dlsociete.push(s.nomSociete);
      }
      
    },err=>{
      console.log(err);
    })
  }

  getCompetences(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.comps = data;
      
      this.dlcomp = [];
      for(let s of this.comps){
        this.dlcomp.push(s.nomCompetence);
      }
      
    },err=>{
      console.log(err);
    })
  }

  getCompetencesCV(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.selectedComps = data;
      console.log(this.selectedComps);      
    },err=>{
      console.log(err);
    })
  }
 
  onIS(item: any) {
    for(let el of this.formations){
      if(el.intitule == item)
        this.selectedFormations.push(el);
    }
    this.sIformation = [];
    for(let el of this.selectedFormations){
        this.sIexp.push(el.intitule);
    }
      
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

  onISposte(item: any) {
    for(let p of this.postes){
      if(p.libellePost == item)
        this.poste = p.codePost;
    }
  }

  onISsociete(item: any) {
    for(let s of this.societes){
      if(s.nomSociete == item)
        this.societe = s.codeSociete;
    }
  }

  onIScomp(item: any) {
    for(let s of this.comps){
      if(s.nomCompetence == item)
        this.comp = s.codeCompetance;
    }
  }

  onISexp(item: any) {
    for(let el of this.experiences){
      if(el.descriptionRole == item)
        this.selectedExps.push(el);
    }
    
  }

  onIDSexp(item: any) {
    this.tmp = [];
    for(let el of this.selectedExps){
      if(el.descriptionRole != item)
        this.tmp.push(el);
    }

    this.selectedExps = this.tmp;
      
    console.log(this.selectedExps);
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

  exp: Experience = new Experience("","","","","","","","");
  
  createExp(exp): void {
  
    exp.cv = this.cv.codeCV;
    exp.poste = this.poste;
    exp.societe = this.societe;

    console.log(exp);

    this.service.createRessources("/admin/saveExperienceCV",exp)
        .subscribe( data => {
          
          alert("Expérience est ajoutée avec succée");
          this.experiences.push(exp);
          this.dlexp = [];
          for(let el of this.experiences){
            this.dlexp.push(el.descriptionRole);
          }
          //this.router.navigate(['/cv/'+cv.codeCV]);
          //this.getCompetence();
        });

  };

  comp: CompetenceCV = new CompetenceCV("","","","");
  
  createComp(comp): void {
  
    comp.cv = this.cv.codeCV;
    comp.competence = this.comp;
    
    console.log(comp);

    this.service.createRessources("/admin/saveCompetenceCV",comp)
        .subscribe( data => {
          
          alert("Competence est ajoutée avec succée");
          this.selectedComps.push(comp);
          
          //this.router.navigate(['/cv/'+cv.codeCV]);
          //this.getCompetence();
        });

  };

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
