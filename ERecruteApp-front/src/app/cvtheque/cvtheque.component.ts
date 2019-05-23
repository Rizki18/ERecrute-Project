import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { UserService, CV } from '../services/user.service';

@Component({
  selector: 'app-cvtheque',
  templateUrl: './cvtheque.component.html',
  styleUrls: ['./cvtheque.component.css']
})
export class CvthequeComponent implements OnInit {

  private cvs;
  cv:CV = new CV("","","","","");
  mode = -1;

  constructor(private service: UserService, private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      console.log(params['id']) //log the value of id
      this.getCVsProfil(params['id']);
    });
    
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

  getCVsProfil(id) {
    
    this.service.getRessources("/profil/"+id+"/cvs")
    .subscribe(data=>{
      this.cvs = data;
    },err=>{
      console.log(err);
    })
  }

}
