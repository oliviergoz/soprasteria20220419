import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Matiere } from 'src/app/formation/model/matiere';
import { MatiereService } from 'src/app/formation/services/matiere.service';

@Component({
  selector: 'app-edit-matiere',
  templateUrl: './edit-matiere.component.html',
  styleUrls: ['./edit-matiere.component.css'],
})
export class EditMatiereComponent implements OnInit {
  matiere: Matiere = new Matiere();

  constructor(
    private aR: ActivatedRoute,
    private matiereService: MatiereService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.matiereService.getById(params['id']).subscribe((data) => {
          this.matiere = data;
        });
      }
    });
  }

  save() {
    console.log(this.matiere);
    if (this.matiere.id) {
      //update
      this.matiereService.update(this.matiere).subscribe((data) => {
        this.router.navigate(['/matiere'], {
          queryParams: { query: 'update', id: this.matiere.id },
        });
      });
    } else {
      //create
      this.matiereService.create(this.matiere).subscribe((data) => {
        this.router.navigate(['/matiere'], {
          queryParams: { query: 'create', id: data.id },
        });
      });
    }
  }
}
