import { Matiere } from './../model/matiere';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MatiereService {
  url: string = 'http://localhost:8080/boot/api/matiere';

  constructor(private httpClient: HttpClient) {}

  getAll(): Observable<Matiere[]> {
    return this.httpClient.get<Matiere[]>(this.url);
  }

  delete(id: number): Observable<void> {
    let httpHeaders: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa('admin:admin'),
    });
    return this.httpClient.delete<void>(`${this.url}/${id}`, {
      headers: httpHeaders,
    });
  }
}
