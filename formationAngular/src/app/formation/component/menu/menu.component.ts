import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from '../../model/compte';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  get logged() {
    return sessionStorage.getItem('token');
  }

  get compte(): Compte | null {
    console.log(sessionStorage.getItem('compte'));
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!) as Compte;
    }
    return null;
  }

  logout() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }
}
