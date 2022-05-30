import { Personne } from './../../model/personne';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo-directive',
  templateUrl: './demo-directive.component.html',
  styleUrls: ['./demo-directive.component.css'],
})
export class DemoDirectiveComponent implements OnInit {
  couleur = 'rouge';
  n = 0;

  list = ['toto', 'titi', 'tutu'];
  personnes = [
    new Personne('olviier', 'gozlan'),
    new Personne('jordan', 'adib'),
  ];

  constructor() {}

  ngOnInit(): void {}

  changeCouleur() {
    return this.couleur != 'rouge';
  }
}
