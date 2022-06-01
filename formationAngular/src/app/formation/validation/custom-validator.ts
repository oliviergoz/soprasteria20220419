import {
  AbstractControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
} from '@angular/forms';

export class CustomValidator {
  public static pasToto(control: AbstractControl): ValidationErrors | null {
    return control.value == 'toto' ? { toto: true } : null;
  }

  public static pasChaineInterdite(chaineInterdite: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      return control.value == chaineInterdite
        ? { chaineInterdite: true }
        : null;
    };
  }

  public static notEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    let login = group.controls['login'];
    let password = group.controls['password'];
    return login.dirty && login.value == password.value
      ? { equals: true }
      : null;
  }
}
