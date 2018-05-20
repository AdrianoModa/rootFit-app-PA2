import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { AvaliacaoFisica } from './../entities/avaliacao-fisica';

@Injectable()
export class AvaliacaoFisicaService {

  avaliacaoURL = 'http://localhost:8080/avaliacaoFisica';

  constructor(private httpCliente: HttpClient) { }

  buscar() {
    return this.httpCliente.get<AvaliacaoFisica[]>(`${this.avaliacaoURL}`);
  }

  buscarPorId(id: number) {
    return this.httpCliente.get<AvaliacaoFisica[]>(`${this.avaliacaoURL}/${id}`);
  }

  atualizar(avaliacao: any) {
    return this.httpCliente.put(this.avaliacaoURL + '/' + `${avaliacao.id}`, avaliacao);
  }

  adicionar(avaliacao: any) {
    return this.httpCliente.post(this.avaliacaoURL, avaliacao);
  }

  remover(id: number) {
    return this.httpCliente.delete(this.avaliacaoURL + '/' + `${id}`);
  }

}
