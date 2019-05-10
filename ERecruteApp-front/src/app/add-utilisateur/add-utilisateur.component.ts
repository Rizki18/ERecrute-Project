import { Component, OnInit } from '@angular/core';

import { UserService } from '../services/user.service';
import { UserInfo } from './user-info';


@Component({
  selector: 'app-add-utilisateur',
  templateUrl: './add-utilisateur.component.html',
  styleUrls: ['./add-utilisateur.component.css']
})
export class AddUtilisateurComponent implements OnInit {


  form: any = {};
  userInfo: UserInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';

  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};
 
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }

  constructor(
    private userService: UserService
  ) { }

  ngOnInit() {
    this.dropdownList = ["admin","responsable","recruteur"];
 
    this.dropdownSettings = {
      singleSelection: false,
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
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
        },
        error => {
          console.log(error);
          this.errorMessage = error.error.message;
          this.isSignUpFailed = true;
        });

  };

}
