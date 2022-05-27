import { Personne } from './../../model/personne';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-edit-personne',
  templateUrl: './edit-personne.component.html',
  styleUrls: ['./edit-personne.component.css'],
})
export class EditPersonneComponent implements OnInit {
  personne: Personne = new Personne();

  @Output()
  personneOutputEvent: EventEmitter<any> = new EventEmitter();
  constructor() {}

  ngOnInit(): void {}

  send() {
    this.personneOutputEvent.emit({
      prenom: this.personne.prenom,
      nom: this.personne.nom,
    });
    this.personne = new Personne();
  }
}
