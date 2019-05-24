import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {

  profil;
  cv;
  formations;

  constructor( private service: UserService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.getCV("/cv/"+params['id']);
      this.getFormations("/profil/"+1+"/formations");

    });
  }

  getCV(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.cv = data;
      console.log(this.cv);
    },err=>{
      console.log(err);
    })
  }

  getFormations(url) {
    this.service.getRessources(url)
    .subscribe(data=>{
      this.formations = data;
      console.log(this.formations);
    },err=>{
      console.log(err);
    })
  }



  

}
