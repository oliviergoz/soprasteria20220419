import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListModuleComponent } from './list-module.component';

describe('ListModuleComponent', () => {
  let component: ListModuleComponent;
  let fixture: ComponentFixture<ListModuleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListModuleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
