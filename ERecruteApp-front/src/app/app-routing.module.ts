import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

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

const routes: Routes = [
  {
    path: 'erecrute/home',
    component: HomeComponent
},
{
    path: 'erecrute/recruteur',
    component: RecruteurComponent
},
{
    path: 'erecrute/responsable',
    component: ResponsableComponent
},
{
    path: 'erecrute/admin',
    component: AdminComponent
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
    component: UtilisateursComponent
},
{
    path: 'erecrute/nv-user',
    component: AddUtilisateurComponent
},
{
    path: 'erecrute/edit-user',
    component: EditUtilisateurComponent
},
{
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
},
{
    path: 'erecrute/criteres',
    component: CriteresComponent
},
{
    path: 'erecrute/addProfil',
    component: AddProfilComponent
},
{
    path: 'erecrute/motcles',
    component: MotClesComponent
},
{
    path: 'erecrute/cv/:id',
    component: CvComponent
},
{
    path: 'erecrute/cvtheque/:id',
    component: CvthequeComponent
}
,
{
    path: 'erecrute/profil',
    component: ProfilComponent
}
,
{
    path: 'poste',
    component: PosteComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
