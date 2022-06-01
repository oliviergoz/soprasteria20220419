import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaireCodeComponent } from './formulaire-code.component';

describe('FormulaireCodeComponent', () => {
  let component: FormulaireCodeComponent;
  let fixture: ComponentFixture<FormulaireCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormulaireCodeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulaireCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
