import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Matiere } from 'src/app/formation/model/matiere';
import { Module } from 'src/app/formation/model/module';
import { MatiereService } from 'src/app/formation/services/matiere.service';
import { ModuleService } from 'src/app/formation/services/module.service';

@Component({
  selector: 'app-edit-module',
  templateUrl: './edit-module.component.html',
  styleUrls: ['./edit-module.component.css'],
})
export class EditModuleComponent implements OnInit {
  module: Module;
  matieres: Observable<Matiere[]>;

  constructor(
    private activatedRoute: ActivatedRoute,
    private moduleService: ModuleService,
    private router: Router,
    private matiereService: MatiereService
  ) {
    this.module = new Module();
    this.module.matiere = new Matiere();
    this.matieres = this.matiereService.getAll();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.moduleService.getById(params['id']).subscribe((data) => {
          this.module = data;
        });
      }
    });
  }
  save() {
    if (this.module.id) {
      console.log('update');
      this.moduleService.update(this.module).subscribe(() => {
        this.router.navigateByUrl('/module');
      });
    } else {
      console.log('create');
      this.moduleService.create(this.module).subscribe(() => {
        this.router.navigateByUrl('/module');
      });
    }
  }

  byId(m1: Matiere, m2: Matiere) {
    if (m1 && m2) {
      return m1.id == m2.id;
    }
    return false;
  }
}
