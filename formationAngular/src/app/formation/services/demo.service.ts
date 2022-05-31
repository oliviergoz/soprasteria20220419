import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  constructor() {
    console.log('creation du demoservice');
  }

  methode(): string {
    console.log('methode du service');
    return 'hello du service';
  }
}
