import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-formulaire-template',
  templateUrl: './formulaire-template.component.html',
  styleUrls: ['./formulaire-template.component.css'],
})
export class FormulaireTemplateComponent implements OnInit {
  input: string = '';

  constructor() {}

  ngOnInit(): void {}

  submit(monForm: any) {
    let formGroup = monForm as FormGroup;
    console.log(formGroup.controls['input']);
  }
}
