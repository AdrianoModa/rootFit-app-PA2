import { TestBed, inject } from '@angular/core/testing';

import { ListarClientesService } from './listar-clientes.service';

describe('ListarClientesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListarClientesService]
    });
  });

  it('should be created', inject([ListarClientesService], (service: ListarClientesService) => {
    expect(service).toBeTruthy();
  }));
});
