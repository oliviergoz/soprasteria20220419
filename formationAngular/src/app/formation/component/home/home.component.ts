import { DemoService } from './../../services/demo.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(private demoService: DemoService) {}

  ngOnInit(): void {
    this.demoService.methode();
  }
}
