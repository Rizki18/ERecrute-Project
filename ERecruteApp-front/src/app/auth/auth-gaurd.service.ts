import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { TokenStorageService } from '../auth/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {

  private roles: string[];

  constructor(private router: Router,
    private token: TokenStorageService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.token.isUserLoggedIn())
      return true;

    this.router.navigate(['erecrute/auth/login']);
    return false;

  }

}