import { Colaborador } from './../entities/colaborador';
import { Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { AuthHttp } from 'angular2-jwt';
import 'rxjs/add/operator/toPromise'
import { promise } from 'protractor';

@Injectable()
export class ColaboradorService {

  colaboradores: any;

  colaboradorUrl = 'http://localhost:8080/colaborador';

  constructor(private http: AuthHttp) { }

  consultar(): Promise<any> {
    return this.http.get(this.colaboradorUrl)
      .toPromise()
      .then( response => response.json());
  }

  consultarPorId(id: number): Promise<any> {
    return this.http.get(`${this.colaboradorUrl}/${id}`)
      .toPromise()
      .then(response => response.json());
  }

  excluir(id: number): Promise<void> {

    return this.http.delete(`${this.colaboradorUrl}/${id}`)
      .toPromise()
      .then(() => null)
  }

  adicionar(colaborador: Colaborador) {
    return this.http.post(this.colaboradorUrl, colaborador);
  }

  // atualizar(colaborador: any) {
  //   return this.http.put(this.colaboradorUrl + '/' + `${colaborador.id}`, colaborador)
  //   .subscribe(dados => this.colaboradores = dados )
  // }

  atualizar(colaborador: Colaborador): Promise<void> {
    return this.http.put(`${this.colaboradorUrl}/${colaborador.id}`, colaborador)
      .toPromise()
      .then(response => response.json());
  }

  // adicionar(colaborador: Colaborador): Promise<Colaborador> {
  //   return this.http.post(this.colaboradorUrl,
  //       JSON.stringify(colaborador))
  //     .toPromise()
  //     .then(response => response.json());
  // }
}
