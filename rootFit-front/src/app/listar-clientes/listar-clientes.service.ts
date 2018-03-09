import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ListarClientesService {

  clientesURL = 'http://localhost:8080/aluno/';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any[]>(`${this.clientesURL}`);
  }

}
