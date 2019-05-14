import { Component, OnInit } from '@angular/core';

import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  info: any;
  private authority: string;

  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};
 
  constructor(private token: TokenStorageService) { }
 
  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };

    this.dropdownSettings = {
      singleSelection: true,
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

    this.info.authorities.every(role => {
      if (role === 'ROLE_ADMIN') {
        this.dropdownList.push("admin");
        return true;
      } else if (role === 'ROLE_RESPONSABLE') {
        this.dropdownList.push("responsable");
        return true;
      }
      this.dropdownList.push("recruteur");
      return true;
    });

    this.info.authorities.every(role => {
      if (role === 'ROLE_ADMIN') {
        this.selectedItems = ["admin"];
        this.authority = 'admin';
        return false;
      } else if (role === 'ROLE_RESPONSABLE') {
        this.selectedItems = ["responsable"];
        this.authority = 'responsable';
        return false;
      }
      this.selectedItems = ["recruteur"];
      this.authority = 'recruteur';
      return true;
    });
  }

  onItemSelect(item: any) {
    this.authority = item;
  }

}
