import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bonjour',
  templateUrl: './bonjour.component.html',
  styleUrls: ['./bonjour.component.css'],
})
export class BonjourComponent implements OnInit {
  prenom: string = '';

  constructor(private aR: ActivatedRoute) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      this.prenom = params['prenom'];
    });
  }
}
