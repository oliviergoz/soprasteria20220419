import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-bonjour',
  templateUrl: './form-bonjour.component.html',
  styleUrls: ['./form-bonjour.component.css'],
})
export class FormBonjourComponent implements OnInit {
  prenom = '';
  showAlert = false;
  message = '';
  constructor(private router: Router) {}

  ngOnInit(): void {}

  send() {
    if (this.prenom) {
      //this.router.navigate(['/bonjour', this.prenom]);
      //this.router.navigateByUrl('/bonjour/'+this.prenom);
      this.showAlert = false;
      this.router.navigateByUrl(`/bonjour/${this.prenom}`);
    } else {
      this.showAlert = true;
      this.message = 'prenom obligatoire';
    }
  }
}
