import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaireTemplateComponent } from './formulaire-template.component';

describe('FormulaireTemplateComponent', () => {
  let component: FormulaireTemplateComponent;
  let fixture: ComponentFixture<FormulaireTemplateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormulaireTemplateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulaireTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
