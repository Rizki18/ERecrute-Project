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
    public roles:string
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class UserService {
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
}
