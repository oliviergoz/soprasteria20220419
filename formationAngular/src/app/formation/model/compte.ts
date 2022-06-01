export class Compte {
  public constructor(
    private _prenom?: string,
    private _nom?: string,
    private _login?: string,
    private _type?: string
  ) {}

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

  get login(): string | undefined {
    return this._login;
  }

  set login(value: string | undefined) {
    this._login = value;
  }

  get type(): string | undefined {
    return this._type;
  }

  set type(value: string | undefined) {
    this._type = value;
  }
}
