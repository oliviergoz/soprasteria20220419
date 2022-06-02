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

  getById(id: number): Observable<Matiere> {
    return this.httpClient.get<Matiere>(`${this.url}/${id}`);
  }

  delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  update(matiere: Matiere): Observable<Matiere> {
    return this.httpClient.put<Matiere>(`${this.url}/${matiere.id}`, matiere);
  }

  create(matiere: Matiere) {
    let matiereJson = {
      libelle: matiere.libelle,
    };
    return this.httpClient.post<Matiere>(this.url, matiereJson);
  }
}
