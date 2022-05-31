import { Matiere } from './../../../model/matiere';
import { MatiereService } from './../../../services/matiere.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-matiere',
  templateUrl: './list-matiere.component.html',
  styleUrls: ['./list-matiere.component.css'],
})
export class ListMatiereComponent implements OnInit {
  matieres: Matiere[] = [];
  message = '';
  showMessage = false;

  constructor(
    private matiereService: MatiereService,
    private aR: ActivatedRoute
  ) {}

  initMatiere() {
    this.matiereService.getAll().subscribe((datas) => {
      this.matieres = datas;
    });
  }

  ngOnInit(): void {
    this.showMessage = false;
    this.aR.queryParams.subscribe((params) => {
      if (params['query']) {
        if (params['query'] === 'create') {
          this.message = `creation de la matiere ${params['id']}`;
        } else if (params['query'] === 'update') {
          this.message = `mise à jour de la matiere ${params['id']}`;
        }
        this.showMessage = true;
      }
    });
    this.initMatiere();
  }
  delete(id: number) {
    this.matiereService.delete(id).subscribe(() => {
      this.message = `matiere ${id} supprimée`;
      this.showMessage = true;
      this.initMatiere();
    });
  }
}
