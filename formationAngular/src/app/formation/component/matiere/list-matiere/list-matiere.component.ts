import { Matiere } from './../../../model/matiere';
import { MatiereService } from './../../../services/matiere.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-matiere',
  templateUrl: './list-matiere.component.html',
  styleUrls: ['./list-matiere.component.css'],
})
export class ListMatiereComponent implements OnInit {
  matieres: Matiere[] = [];
  message = '';
  showMessage = false;

  constructor(private matiereService: MatiereService) {}

  initMatiere() {
    this.matiereService.getAll().subscribe((datas) => {
      console.log(datas);
      this.matieres = datas;
    });
  }

  ngOnInit(): void {
    this.showMessage = false;
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
