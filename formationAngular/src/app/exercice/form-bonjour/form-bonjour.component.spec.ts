import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormBonjourComponent } from './form-bonjour.component';

describe('FormBonjourComponent', () => {
  let component: FormBonjourComponent;
  let fixture: ComponentFixture<FormBonjourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormBonjourComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormBonjourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
