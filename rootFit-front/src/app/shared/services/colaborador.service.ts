import { Colaborador } from './../entities/colaborador';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ColaboradorService {

  colaboradorURL = 'http://localhost:8080/colaborador';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Colaborador[]>(this.colaboradorURL);
  }

  adicionar(colaborador: Colaborador) {
    return this.http.post(this.colaboradorURL, colaborador);
  }

  remover(id) {
    return this.http.delete(this.colaboradorURL + '/' + `${id}`);
  }

}
