import { Component, OnInit } from '@angular/core';

import { UserService,User } from '../services/user.service';

@Component({
  selector: 'app-utilisateurs',
  templateUrl: './utilisateurs.component.html',
  styleUrls: ['./utilisateurs.component.css']
})
export class UtilisateursComponent implements OnInit {

  public popoverTitle: string = 'Popover title';
  public popoverMessage: string = 'Popover description';

  private utilisateurs;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUtilisateurs();
  }

  getUtilisateurs() {
    this.userService.getRessources("/utilisateurs")
    .subscribe(data=>{
      this.utilisateurs = data;
    },err=>{
      console.log(err);
    })
  }

  deleteUser(user:User): void {
    this.userService.deleteRessources("/admin/deleteUser/"+ user.id)
    .subscribe( data => {
      this.utilisateurs = this.utilisateurs.filter(u => u !== user);
    });
  }

}
