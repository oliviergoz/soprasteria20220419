import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-election',
  templateUrl: './election.component.html',
  styleUrls: ['./election.component.css'],
})
export class ElectionComponent implements OnInit {
  candidatEnTete: string = '';
  vote: number = 0;

  constructor() {}

  ngOnInit(): void {}

  traitementVote(data: any) {
    if (this.vote < data.vote) {
      this.vote = data.vote;
      this.candidatEnTete = data.candidat;
    }
  }

  nom(): string {
    return 'toto';
  }
}
