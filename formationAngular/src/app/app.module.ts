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

@NgModule({
  declarations: [AppComponent, DemoComponent, AutreComponent, CouleurComponent, PersonneComponent, ShowPersonneComponent, EditPersonneComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
