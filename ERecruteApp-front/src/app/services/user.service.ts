import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export class User{
  constructor(
    public id:string,
    public username:string,
    public password:string,
    public name:string,
    public email:string,
    public role:string[]
  ) {}
}

export class Role{
  constructor(
    public id:string,
    public name:string
  ) {}
}

export class Competence{
  constructor(
    public codeCompetance:string,
    public nomCompetence:string
  ) {}
}

export class Competence{
  constructor(
    public codeCompetance:string,
    public nomCompetence:string
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private user:User;

  private userUrl = 'http://localhost:8080/api/test/recruteur';
  private pmUrl = 'http://localhost:8080/api/test/responsable';
  private adminUrl = 'http://localhost:8080/api/test/admin';

  public host:string = "http://localhost:8080"

  constructor( private http:HttpClient) { }

  public getRessources(url)
  {
    return this.http.get(this.host + url);
  }

  public createRessources(url,element)
  {
    return this.http.post(this.host+url,element);
  }

  updateRessources(url,element) {
<<<<<<< HEAD
    return this.http.put(this.host+url,element);
=======
    return this.http.post(this.host+url,element);
>>>>>>> 9329eeca1c67666855b833434876047bfc34fab6
  }

  public deleteRessources(url)
  {
    return this.http.delete(this.host+url);
  }

  getUserBoard(): Observable<string> {
    return this.http.get(this.userUrl, { responseType: 'text' });
  }

  getPMBoard(): Observable<string> {
    return this.http.get(this.pmUrl, { responseType: 'text' });
  }

  getAdminBoard(): Observable<string> {
    return this.http.get(this.adminUrl, { responseType: 'text' });
  }

<<<<<<< HEAD
  setter(user:User,roles:Role[]){
    this.user = user;
    this.user.role = [];
    for (let element of roles) {
      if(element.name == "ROLE_ADMIN")
        user.role.push("admin");
      else if(element.name == "ROLE_RECRUTEUR")
        user.role.push("recruteur");
      else if(element.name == "ROLE_RESPONSABLE")
        user.role.push("responsable");
    }
  }

  getter(){
=======
  setter(user:User){
    this.user = user;
  }

  getter(user:User){
>>>>>>> 9329eeca1c67666855b833434876047bfc34fab6
    return this.user;
  }
}
