import { Component, OnInit } from '@angular/core';

<<<<<<< HEAD
import { UserService, User } from '../services/user.service';

=======
>>>>>>> 9329eeca1c67666855b833434876047bfc34fab6
@Component({
  selector: 'app-edit-utilisateur',
  templateUrl: './edit-utilisateur.component.html',
  styleUrls: ['./edit-utilisateur.component.css']
})
export class EditUtilisateurComponent implements OnInit {

<<<<<<< HEAD
  private user:User;

  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};
 
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.dropdownList = ["admin","responsable","recruteur"];

    this.dropdownSettings = {
      singleSelection: false,
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

    this.user=this.userService.getter();
    
        for (let element of this.user.role) {
          console.log(element);    
          this.selectedItems.push(element); 
        }
        
  }

  updateUser(){
      console.log(this.user);
       
    
=======
  constructor() { }

  ngOnInit() {
>>>>>>> 9329eeca1c67666855b833434876047bfc34fab6
  }

}
