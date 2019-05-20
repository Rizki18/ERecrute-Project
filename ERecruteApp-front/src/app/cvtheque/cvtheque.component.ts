import { Component, OnInit } from '@angular/core';
import { UserService, CV } from '../services/user.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-cvtheque',
  templateUrl: './cvtheque.component.html',
  styleUrls: ['./cvtheque.component.css']
})
export class CvthequeComponent implements OnInit {

  private cvs;
  cv:CV = new CV("","","","","");
  mode = -1;

  constructor(private service: UserService, private router:Router) { }

  ngOnInit() {
    this.getCVs();
  }

  createCv(cv): void {
    console.log(cv);
    
    this.service.createRessources("/admin/saveCv",cv)
        .subscribe( data => {
          
          alert("CV added successfully.");
          //this.router.navigate(['/cv/'+cv.codeCV]);
          //this.getCompetence();
        });

    this.cv.nomCV ='';

    this.cv.posteDesire ='';
    
  };

  addCV(){
    this.mode = 1;
  }

  getCVs() {
    this.service.getRessources("/cvs")
    .subscribe(data=>{
      this.cvs = data;
    },err=>{
      console.log(err);
    })
  }

}
