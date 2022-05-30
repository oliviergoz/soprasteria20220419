import { Produit } from './../produit/produit';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css'],
})
export class EditProduitComponent implements OnInit {
  produit: Produit = new Produit();
  @Input('button')
  texteButton = '';
  @Output()
  produitReady: EventEmitter<Produit> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  send() {
    this.produitReady.emit(this.produit);
    this.produit = new Produit();
  }
}
