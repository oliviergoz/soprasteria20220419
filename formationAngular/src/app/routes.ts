import { ListMatiereComponent } from './formation/component/matiere/list-matiere/list-matiere.component';
import { BonjourComponent } from './exercice/bonjour/bonjour.component';
import { FormBonjourComponent } from './exercice/form-bonjour/form-bonjour.component';
import { QueryParamsComponent } from './formation/component/query-params/query-params.component';
import { ParametreComponent } from './formation/component/parametre/parametre.component';
import { ListProduitComponent } from './exercice/directive/list-produit/list-produit.component';
import { HomeComponent } from './formation/component/home/home.component';
import { Routes } from '@angular/router';
import { EditMatiereComponent } from './formation/component/matiere/edit-matiere/edit-matiere.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ListProduitComponent, outlet: 'footer' },
  { path: 'parametre/:param', component: ParametreComponent, outlet: 'footer' },
  { path: 'query-param', component: QueryParamsComponent },
  { path: 'form', component: FormBonjourComponent },
  { path: 'bonjour/:prenom', component: BonjourComponent },
  { path: 'matiere', component: ListMatiereComponent },
  { path: 'matiere/edit', component: EditMatiereComponent },
  { path: 'matiere/edit/:id', component: EditMatiereComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
