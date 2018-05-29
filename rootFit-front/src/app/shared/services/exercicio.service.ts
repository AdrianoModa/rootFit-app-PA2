import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { Exercicio } from './../entities/exercicio';

@Injectable()
export class ExercicioService {

  exercicioURL = "http://localhost:8080/exercicio";

  constructor(private httpCliente: HttpClient) { }

  buscar() {
    return this.httpCliente.get<Exercicio[]>(`${this.exercicioURL}`);
  }

  buscarPorId(id: number) {
    return this.httpCliente.get<Exercicio[]>(`${this.exercicioURL}/${id}`);
  }

  adicionar(exercicio: any) {
    return this.httpCliente.post(this.exercicioURL, exercicio);
  }

  atualizar(exercicio: any) {
    return this.httpCliente.put(this.exercicioURL + '/' + `${exercicio.id}`, exercicio);
  }

  remover(id: number) {
    return this.httpCliente.delete(this.exercicioURL + '/' + `${id}`);
  }

}
