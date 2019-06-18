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

  form: any = {};
  userInfo: UserInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';

  public popoverTitle: string = 'Supprimer utilisateur';
  public popoverMessage: string = 'êtes-vous sûr de vouloir supprimer cet utilisateur';

  private utilisateurs;


  mode = "-1";

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
    this.dropdownList = ["admin","responsable","recruteur"];
    this.dropdownSettings = {
      singleSelection: false,
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

    
  }

  getUtilisateurs() {
    this.userService.getRessources("/admin/utilisateurs")
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

  createUser(): void {
    console.log(this.form);
    this.userInfo = new UserInfo(
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password,
      this.form.role);

    this.userService.createRessources("/admin/saveUser",this.userInfo)
        .subscribe( data => {
          console.log(data);
          this.isSignedUp = true;
          this.isSignUpFailed = false;
          this.getUtilisateurs();
        },
        error => {
          console.log(error);
          this.errorMessage = error.error.message;
          this.isSignUpFailed = true;
        });

  };

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
    
    this.mode = "-1";
    console.log(user);
    console.log(roles);
    this.userInfo = new UserInfo(
      user.name,
      user.username,
      user.email,
      user.password,
      roles);


    this.userService.updateRessources("/admin/updateUser/"+user.id,this.userInfo)
        .subscribe( data => {
          console.log(data);
          this.getUtilisateurs();
        },
        error => {
          console.log(error);
        });
  };

}
