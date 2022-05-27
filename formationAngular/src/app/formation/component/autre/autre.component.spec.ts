import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutreComponent } from './autre.component';

describe('AutreComponent', () => {
  let component: AutreComponent;
  let fixture: ComponentFixture<AutreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AutreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AutreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
