import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-parametre',
  templateUrl: './parametre.component.html',
  styleUrls: ['./parametre.component.css'],
})
export class ParametreComponent implements OnInit {
  nom = '';

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    //this.nom = this.activatedRoute.snapshot.params['param'];

    this.activatedRoute.params.subscribe((params) => {
      this.nom = params['param'];
    });
  }
}
