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

import { CompetenceComponent } from './competence/competence.component';

import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { NgDatepickerModule } from 'ng2-datepicker';

import { EditUtilisateurComponent } from './edit-utilisateur/edit-utilisateur.component';
import { CriteresComponent } from './criteres/criteres.component';
import { CvComponent } from './cv/cv.component';
import { CvthequeComponent } from './cvtheque/cvtheque.component';
import { LanguesComponent } from './langues/langues.component';
import { SecteurActiviteComponent } from './secteur-activite/secteur-activite.component';
import { SituationFamilialeComponent } from './situation-familiale/situation-familiale.component';
import { TypeProfilComponent } from './type-profil/type-profil.component';
import { TypeContratComponent } from './type-contrat/type-contrat.component';
import { ProfilComponent } from './profil/profil.component';
import { AddProfilComponent } from './add-profil/add-profil.component';
import { PosteComponent } from './poste/poste.component';
import { MotClesComponent } from './mot-cles/mot-cles.component';
import { RecrutementComponent } from './recrutement/recrutement.component';
import { SocieteComponent } from './societe/societe.component';
import { AccesRefuseComponent } from './errors/acces-refuse/acces-refuse.component';
import { NvRecrutementComponent } from './nv-recrutement/nv-recrutement.component';
import { ChangementPosteComponent } from './changement-poste/changement-poste.component';

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
    EditUtilisateurComponent,
    CompetenceComponent,
    CriteresComponent,
    CvComponent,
    CvthequeComponent,
    LanguesComponent,
    SecteurActiviteComponent,
    SituationFamilialeComponent,
    TypeProfilComponent,
    TypeContratComponent,
    ProfilComponent,
    AddProfilComponent,
    PosteComponent,
    MotClesComponent,
    RecrutementComponent,
    SocieteComponent,
    AccesRefuseComponent,
    NvRecrutementComponent,
    ChangementPosteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    //NgbModule,
    NgMultiSelectDropDownModule.forRoot(),
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger' // set defaults here
    }),
    NgDatepickerModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
