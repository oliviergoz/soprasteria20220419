import { Personne } from './../model/personne';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css'],
})
export class DemoComponent implements OnInit {
  prenom: string = 'olivier';
  personne: Personne = new Personne('olivier', 'gozlan');
  couleur = 'yellow';

  constructor() {}

  ngOnInit(): void {}

  clickBouton() {
    console.log('click sur le bouton');
  }
}
