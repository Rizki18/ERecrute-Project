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

  mode;

  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};
 
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }

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

  editUser(user:User,roles): void {
    this.mode = user.id;
    
    this.dropdownList = ["admin","responsable","recruteur"];

    this.dropdownSettings = {
      singleSelection: false,
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

    this.selectedItems = [];
    for (let element of roles) {
      if(element.name == "ROLE_ADMIN")
        this.selectedItems.push("admin");
      else if(element.name == "ROLE_RECRUTEUR")
        this.selectedItems.push("recruteur");
      else if(element.name == "ROLE_RESPONSABLE")
        this.selectedItems.push("responsable");
    }
/*
    this.userService.setter(user,roles);
    //this.form.role = user.roles;
    this.router.navigate(['/edit-user']);*/
  }

  updateUser(user,roles): void {
    console.log(user);
    console.log(roles);
    this.userInfo = new UserInfo(
      user.name,
      user.username,
      user.email,
      user.password,
      roles);

    this.userService.createRessources("/admin/saveUser",this.userInfo)
        .subscribe( data => {
          console.log(data);
        },
        error => {
          console.log(error);
        });
  };

}
