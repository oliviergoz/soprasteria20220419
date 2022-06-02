import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  public auth(login: string, password: string): Observable<Compte> {
    let monHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(`${login}:${password}`),
    });
    return this.httpClient.get<Compte>('http://localhost:8080/boot/api/auth', {
      headers: monHeaders,
    });
  }

  public get authenticated(): boolean {
    return sessionStorage.getItem('token') ? true : false;
  }

  constructor(private httpClient: HttpClient) {}
}
