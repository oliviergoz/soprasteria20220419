import { TestBed } from '@angular/core/testing';

import { AuthenticatedGuardService } from './authenticated-guard.service';

describe('AuthenticatedGuardService', () => {
  let service: AuthenticatedGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenticatedGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
