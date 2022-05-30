import { Produit } from './../produit/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent implements OnInit {
  produits: Array<Produit> = [
    new Produit('pomme', 1),
    new Produit('tele', 500),
  ];

  constructor() {}

  ngOnInit(): void {}

  addProduit(produit: Produit) {
    this.produits.push(produit);
  }

  getInfo(prix: number): string {
    if (prix < 0) {
      return 'erreur';
    } else if (prix == 0) {
      return '???';
    } else {
      return 'ok';
    }
  }
}
