import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Aluno } from './../entities/aluno';
import { AuthHttp } from 'angular2-jwt';

@Injectable()
export class AlunoService {

  alunoURL = 'http://localhost:8080/aluno';

  constructor(private httpCliente: HttpClient, private http: AuthHttp) { }

  consultar(): Promise<any> {
    return this.http.get(this.alunoURL)
      .toPromise()
      .then( response => response.json());
  }

  buscar() {
    return this.httpCliente.get<Aluno[]>(`${this.alunoURL}`);
  }

  buscarPorId(id: number) {
    return this.httpCliente.get<Aluno[]>(`${this.alunoURL}/${id}`);
  }

  adicionar(aluno: any) {
    return this.httpCliente.post(this.alunoURL, aluno);
  }

  atualizar(aluno: any) {
    return this.httpCliente.put(this.alunoURL + '/' + `${aluno.id}`, aluno);
  }

  remover(id: number) {
    return this.httpCliente.delete(this.alunoURL + '/' + `${id}`);
  }

}
