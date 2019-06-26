import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGaurdService } from './auth/auth-gaurd.service';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { RecruteurComponent } from './recruteur/recruteur.component';
import { ResponsableComponent } from './responsable/responsable.component';
import { AdminComponent } from './admin/admin.component';
import { UtilisateursComponent } from './utilisateurs/utilisateurs.component';
import { AddUtilisateurComponent } from './add-utilisateur/add-utilisateur.component';
import { EditUtilisateurComponent } from './edit-utilisateur/edit-utilisateur.component';
import { CriteresComponent } from './criteres/criteres.component';
import { CvComponent } from './cv/cv.component';
import { CvthequeComponent } from './cvtheque/cvtheque.component';
import { ProfilComponent } from './profil/profil.component';
import { PosteComponent } from './poste/poste.component';
import { AddProfilComponent } from './add-profil/add-profil.component';
import { MotClesComponent } from './mot-cles/mot-cles.component';
import { RecrutementComponent } from './recrutement/recrutement.component';
import { NvRecrutementComponent } from './nv-recrutement/nv-recrutement.component';
import { ChangementPosteComponent } from './changement-poste/changement-poste.component';
import { AccesRefuseComponent } from './errors/acces-refuse/acces-refuse.component';

const routes: Routes = [
  {
    path: 'erecrute/home',
    component: HomeComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/recruteur',
    component: RecruteurComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/responsable',
    component: ResponsableComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/admin',
    component: AdminComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/auth/login',
    component: LoginComponent
},
{
    path: 'erecrute/signup',
    component: RegisterComponent
},
{
    path: 'erecrute/utilisateurs',
    component: UtilisateursComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/recrutement',
    component: NvRecrutementComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/changementPoste',
    component: ChangementPosteComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/nvRecrutement',
    component: RecrutementComponent,
    canActivate:[AuthGaurdService]
},
{
    path: '',
    redirectTo: 'erecrute/home',
    pathMatch: 'full'
},
{
    path: 'erecrute/criteres',
    component: CriteresComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/addProfil',
    component: AddProfilComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/motcles',
    component: MotClesComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/cv/:id',
    component: CvComponent,
    canActivate:[AuthGaurdService]
},
{
    path: 'erecrute/cvtheque/:id',
    component: CvthequeComponent,
    canActivate:[AuthGaurdService]
}
,
{
    path: 'erecrute/profil',
    component: ProfilComponent,
    canActivate:[AuthGaurdService]
}
,
{
    path: 'erecrute/poste',
    component: PosteComponent,
    canActivate:[AuthGaurdService],
}
,
{
    path: 'erecrute/error-acces-refuse',
    component: AccesRefuseComponent,
    canActivate:[AuthGaurdService],
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
