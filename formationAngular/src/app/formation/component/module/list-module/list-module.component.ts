import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Module } from 'src/app/formation/model/module';
import { ModuleService } from 'src/app/formation/services/module.service';

@Component({
  selector: 'app-list-module',
  templateUrl: './list-module.component.html',
  styleUrls: ['./list-module.component.css'],
})
export class ListModuleComponent implements OnInit {
  modules: Observable<Module[]>;

  constructor(private moduleService: ModuleService) {
    this.modules = this.moduleService.getAll();
  }

  ngOnInit(): void {}

  delete(id: number) {
    this.moduleService.delete(id).subscribe(() => {
      this.modules = this.moduleService.getAll();
    });
  }
}
