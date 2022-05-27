import { Personne } from './../../model/personne';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css'],
})
export class PersonneComponent implements OnInit {
  p: Personne = new Personne('olivier', 'gozlan');
  constructor() {}

  ngOnInit(): void {}

  getPersonne(personne: any) {
    this.p = personne;
  }
}
