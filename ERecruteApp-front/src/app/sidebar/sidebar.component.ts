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
 
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
 
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
        this.selectedItems.push("admin");
        this.authority = 'admin';
        return false;
      } else if (role === 'ROLE_RESPONSABLE') {
        this.dropdownList.push("responsable");
        this.selectedItems.push("responsable");
        this.authority = 'responsable';
        return false;
      }
      this.dropdownList.push("recruteur");
      this.selectedItems.push("recruteur");
      this.authority = 'recruteur';
      return true;
    });
  }

}
