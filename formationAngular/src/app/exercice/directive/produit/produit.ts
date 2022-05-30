export class Produit {
  public constructor(private _nom?: string, private _prix?: number) {}

  public get nom(): string | undefined {
    return this._nom;
  }
  public get prix(): number | undefined {
    return this._prix;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }
}
