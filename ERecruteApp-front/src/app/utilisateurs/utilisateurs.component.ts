import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { UserService,User } from '../services/user.service';
import { UserInfo } from '../add-utilisateur/user-info';

@Component({
  selector: 'app-utilisateurs',
  templateUrl: './utilisateurs.component.html',
  styleUrls: ['./utilisateurs.component.css']
})
export class UtilisateursComponent implements OnInit {

  public popoverTitle: string = 'Supprimer utilisateur';
  public popoverMessage: string = 'êtes-vous sûr de vouloire supprimer ce utilisateur';

  private utilisateurs;
  form: any = {};
  userInfo: UserInfo;

  constructor(private userService: UserService, private router:Router) { }

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

  editUser(user:User): void {
    this.userService.setter(user);
    //this.form.role = user.roles;
    this.router.navigate(['/nv-user']);
  }

}
