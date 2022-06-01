import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { CustomValidator } from 'src/app/formation/validation/custom-validator';

@Component({
  selector: 'app-formulaire-code',
  templateUrl: './formulaire-code.component.html',
  styleUrls: ['./formulaire-code.component.css'],
})
export class FormulaireCodeComponent implements OnInit {
  monForm: FormGroup;

  constructor() {
    //constructor(private fb:FormBuilder) {
    // this.monForm=this.fb.group({})
    this.monForm = new FormGroup({
      prenom: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
      ]),
      nom: new FormControl('', [
        CustomValidator.pasToto,
        CustomValidator.pasChaineInterdite('tutu'),
      ]),
      loginPasswordGroup: new FormGroup(
        {
          login: new FormControl('', [Validators.required, Validators.email]),
          password: new FormControl('', Validators.required),
        },
        CustomValidator.notEquals
      ),
    });
  }

  ngOnInit(): void {}

  submit() {
    console.log(this.monForm.get('loginPasswordGroup.login'));
  }
}
