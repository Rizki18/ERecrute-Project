import { Component, OnInit } from '@angular/core';
import { UserService, CV } from '../services/user.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-cvtheque',
  templateUrl: './cvtheque.component.html',
  styleUrls: ['./cvtheque.component.css']
})
export class CvthequeComponent implements OnInit {

  cv:CV = new CV("","","","");

  constructor(private service: UserService, private router:Router) { }

  ngOnInit() {
  }

  createCv(cv): void {
    console.log(cv);
    
    this.service.createRessources("/admin/saveCv",cv)
        .subscribe( data => {
          alert("CV added successfully.");
          this.router.navigate(['/cv']);
          //this.getCompetence();
        });

    this.cv.nomCV ='';

    this.cv.posteDesire ='';
    
  };

}
