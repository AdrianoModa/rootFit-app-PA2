import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { FichaTreino } from './../entities/ficha-treino';

@Injectable()
export class FichaTreinoService {

  fichaTreinoURL = "http://localhost:8080/ficha-treino";

  constructor(private httpCliente: HttpClient) { }

  buscar() {
    return this.httpCliente.get<FichaTreino[]>(`${this.fichaTreinoURL}`);
  }

  buscarPorId(id: number) {
    return this.httpCliente.get<FichaTreino[]>(`${this.fichaTreinoURL}/${id}`);
  }

  adicionar(ficha: any) {
    return this.httpCliente.post(this.fichaTreinoURL, ficha);
  }

  atualizar(ficha: any) {
    return this.httpCliente.put(this.fichaTreinoURL + '/' + `${ficha.id}`, ficha);
  }

  remover(id: number) {
    return this.httpCliente.delete(this.fichaTreinoURL + '/' + `${id}`);
  }

}
