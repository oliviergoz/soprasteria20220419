import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Module } from '../model/module';

@Injectable({
  providedIn: 'root',
})
export class ModuleService {
  private url: string = 'http://localhost:8080/boot/api/module';

  constructor(private httpClient: HttpClient) {}

  private get headers(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Basic ' + btoa('admin:admin'),
    });
  }

  public getAll(): Observable<Module[]> {
    return this.httpClient.get<Module[]>(this.url, { headers: this.headers });
  }

  public getById(id: number): Observable<Module> {
    return this.httpClient.get<Module>(`${this.url}/${id}`, {
      headers: this.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`, {
      headers: this.headers,
    });
  }

  public update(module: Module): Observable<Module> {
    return this.httpClient.put<Module>(
      `${this.url}/${module.id}`,
      this.moduleToJson(module),
      {
        headers: this.headers,
      }
    );
  }

  private moduleToJson(module: Module): any {
    let obj = {
      code: module.code,
      debut: module.debut,
      fin: module.fin,
    };
    if (module.matiere?.id) {
      Object.assign(obj, { matiere: { id: module.matiere?.id } });
    }
    if (module.id) {
      Object.assign(obj, { id: module.id });
    }
    return obj;
  }

  public create(module: Module): Observable<Module> {
    return this.httpClient.post<Module>(this.url, this.moduleToJson(module), {
      headers: this.headers,
    });
  }
}
