import { FormBonjourComponent } from './exercice/form-bonjour/form-bonjour.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoComponent } from './formation/demo/demo.component';
import { AutreComponent } from './formation/component/autre/autre.component';
import { FormsModule } from '@angular/forms';
import { CouleurComponent } from './exercice/couleur/couleur/couleur.component';
import { PersonneComponent } from './formation/component/personne/personne.component';
import { ShowPersonneComponent } from './formation/component/show-personne/show-personne.component';
import { EditPersonneComponent } from './formation/component/edit-personne/edit-personne.component';
import { CandidatComponent } from './exercice/vote/candidat/candidat.component';
import { ElectionComponent } from './exercice/vote/election/election.component';
import { TestComponent } from './exercice/vote/test/test.component';
import { DemoDirectiveComponent } from './formation/component/demo-directive/demo-directive.component';
import { ListProduitComponent } from './exercice/directive/list-produit/list-produit.component';
import { EditProduitComponent } from './exercice/directive/edit-produit/edit-produit.component';
import { DemoDirective } from './formation/directive/demo.directive';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { ParametreComponent } from './formation/component/parametre/parametre.component';
import { QueryParamsComponent } from './formation/component/query-params/query-params.component';
import { routes } from './routes';
import { ListMatiereComponent } from './formation/component/matiere/list-matiere/list-matiere.component';
import { MenuComponent } from './formation/component/menu/menu.component';
import { EditMatiereComponent } from './formation/component/matiere/edit-matiere/edit-matiere.component';
import { ListModuleComponent } from './formation/component/module/list-module/list-module.component';
import { EditModuleComponent } from './formation/component/module/edit-module/edit-module.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    AutreComponent,
    CouleurComponent,
    PersonneComponent,
    ShowPersonneComponent,
    EditPersonneComponent,
    CandidatComponent,
    ElectionComponent,
    TestComponent,
    DemoDirectiveComponent,
    ListProduitComponent,
    EditProduitComponent,
    DemoDirective,
    ParametreComponent,
    QueryParamsComponent,
    FormBonjourComponent,
    ListMatiereComponent,
    MenuComponent,
    EditMatiereComponent,
    ListModuleComponent,
    EditModuleComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
