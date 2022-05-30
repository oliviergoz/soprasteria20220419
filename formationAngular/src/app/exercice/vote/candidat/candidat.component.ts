import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'candidat',
  templateUrl: './candidat.component.html',
  styleUrls: ['./candidat.component.css'],
})
export class CandidatComponent implements OnInit {
  @Input()
  nom: string = '';

  vote: number = 0;

  @Output()
  voteRecu: EventEmitter<any> = new EventEmitter();
  constructor() {}

  ngOnInit(): void {}

  voter() {
    this.vote++;
    this.voteRecu.emit({
      candidat: this.nom,
      vote: this.vote,
    });
  }
}
