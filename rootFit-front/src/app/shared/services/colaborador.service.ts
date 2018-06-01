import { Colaborador } from './../entities/colaborador';
import { Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { AuthHttp } from 'angular2-jwt';
import 'rxjs/add/operator/toPromise'
import { promise } from 'protractor';

@Injectable()
export class ColaboradorService {

  colaboradorUrl = 'http://localhost:8080/colaborador';

  constructor(private http: AuthHttp) { }

  consultar(): Promise<any> {
    return this.http.get(this.colaboradorUrl)
      .toPromise()
      .then( response => response.json());
  }

  excluir(id: number): Promise<void> {

    return this.http.delete(`${this.colaboradorUrl}/${id}`)
      .toPromise()
      .then(() => null)
  }

  adicionar(colaborador: Colaborador) {
    return this.http.post(this.colaboradorUrl, colaborador);
  }

  // adicionar(colaborador: Colaborador): Promise<Colaborador> {
  //   return this.http.post(this.colaboradorUrl,
  //       JSON.stringify(colaborador))
  //     .toPromise()
  //     .then(response => response.json());
  // }
}
