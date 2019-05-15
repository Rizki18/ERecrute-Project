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

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
},
{
    path: 'recruteur',
    component: RecruteurComponent
},
{
    path: 'responsable',
    component: ResponsableComponent
},
{
    path: 'admin',
    component: AdminComponent
},
{
    path: 'auth/login',
    component: LoginComponent
},
{
    path: 'signup',
    component: RegisterComponent
},
{
    path: 'utilisateurs',
    component: UtilisateursComponent
},
{
    path: 'nv-user',
    component: AddUtilisateurComponent
},
{
    path: 'edit-user',
    component: EditUtilisateurComponent
},
{
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
},
{
    path: 'criteres',
    component: CriteresComponent
},
{
    path: 'cv',
    component: CvComponent
},
{
    path: 'cvtheque',
    component: CvthequeComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
