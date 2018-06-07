import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Instrutor } from './../entities/instrutor';
import { AuthHttp } from 'angular2-jwt';

@Injectable()
export class InstrutorService {

  instrutorURL = 'http://localhost:8080/instrutor'

  constructor(private httpCliente: HttpClient, private http: AuthHttp) { }

  consultar(): Promise<any> {
    return this.http.get(this.instrutorURL)
      .toPromise()
      .then( response => response.json());
  }

  buscar() {
    return this.httpCliente.get<Instrutor[]>(`${this.instrutorURL}`);
  }

  buscarPorId(id: number) {
    return this.httpCliente.get<Instrutor[]>(`${this.instrutorURL}/${id}`);
  }

  adicionar(instrutor: any) {
    return this.httpCliente.post(this.instrutorURL, instrutor);
  }

  atualizar(instrutor: any) {
    return this.httpCliente.put(this.instrutorURL + '/' + `${instrutor.id}`, instrutor);
  }

  remover(id: number) {
    return this.httpCliente.delete(this.instrutorURL + '/' + `${id}`);
  }

}
