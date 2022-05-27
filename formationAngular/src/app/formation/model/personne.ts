export class Personne {
  // private prenom: string | undefined;
  // private nom: string | undefined;

  // public constructor(prenom?: string, nom?: string) {
  //   this.nom = nom;
  //   this.prenom = prenom;
  // }
  public constructor(private _prenom?: string, private _nom?: string) {}

  get prenom(): string | undefined {
    return this._prenom;
  }

  set prenom(value: string | undefined) {
    this._prenom = value;
  }

  get nom(): string | undefined {
    return this._nom;
  }

  set nom(value: string | undefined) {
    this._nom = value;
  }
}
