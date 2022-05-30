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
import { routes } from './routes';
import { ParametreComponent } from './formation/component/parametre/parametre.component';
import { QueryParamsComponent } from './formation/component/query-params/query-params.component';
import { FormBonjourComponent } from './exercice/form-bonjour/form-bonjour.component';
import { BonjourComponent } from './exercice/bonjour/bonjour.component';
import { LienDirective } from './formation/directive/lien.directive';

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
    BonjourComponent,
    LienDirective,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
