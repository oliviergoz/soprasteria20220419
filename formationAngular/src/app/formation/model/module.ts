import { Matiere } from './matiere';

export class Module {
  public constructor(
    private _id?: number,
    private _debut?: Date,
    private _fin?: Date,
    private _code?: number,
    private _matiere?: Matiere
  ) {}

  get id(): number | undefined {
    return this._id;
  }

  set id(value: number | undefined) {
    this._id = value;
  }
  get code(): number | undefined {
    return this._code;
  }

  set code(value: number | undefined) {
    this._code = value;
  }

  get debut(): Date | undefined {
    return this._debut;
  }

  set debut(value: Date | undefined) {
    this._debut = value;
  }
  get fin(): Date | undefined {
    return this._fin;
  }

  set fin(value: Date | undefined) {
    this._fin = value;
  }

  get matiere(): Matiere | undefined {
    return this._matiere;
  }

  set matiere(value: Matiere | undefined) {
    this._matiere = value;
  }
}
