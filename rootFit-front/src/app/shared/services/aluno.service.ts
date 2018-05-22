import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Aluno } from './../entities/aluno';

@Injectable()
export class AlunoService {

  alunoURL = 'http://localhost:8080/aluno';

  constructor(private httpCliente: HttpClient) { }

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
