import { TestBed } from '@angular/core/testing';

import { AnonymousService } from './anonymous.service';

describe('AnonymousService', () => {
  let service: AnonymousService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnonymousService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
