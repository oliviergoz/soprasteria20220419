import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowPersonneComponent } from './show-personne.component';

describe('ShowPersonneComponent', () => {
  let component: ShowPersonneComponent;
  let fixture: ComponentFixture<ShowPersonneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowPersonneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowPersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
