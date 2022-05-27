import { Personne } from './../../model/personne';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-show-personne',
  templateUrl: './show-personne.component.html',
  styleUrls: ['./show-personne.component.css'],
})
export class ShowPersonneComponent implements OnInit {
  @Input()
  personne: Personne = new Personne();

  @Input('autre_input')
  autrePersonne: Personne = new Personne();

  constructor() {}

  ngOnInit(): void {}
}
