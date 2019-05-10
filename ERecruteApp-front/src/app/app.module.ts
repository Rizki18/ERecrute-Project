import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { RecruteurComponent } from './recruteur/recruteur.component';
import { ResponsableComponent } from './responsable/responsable.component';
import { AdminComponent } from './admin/admin.component';

import { httpInterceptorProviders } from './auth/auth-interceptor';
import { SidebarComponent } from './sidebar/sidebar.component';
import { UtilisateursComponent } from './utilisateurs/utilisateurs.component';
import { AddUtilisateurComponent } from './add-utilisateur/add-utilisateur.component';

import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { CompetenceComponent } from './competence/competence.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    RecruteurComponent,
    ResponsableComponent,
    AdminComponent,
    SidebarComponent,
    UtilisateursComponent,
    AddUtilisateurComponent,
    CompetenceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgMultiSelectDropDownModule.forRoot(),
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger' // set defaults here
    })
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
