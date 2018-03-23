import { Colaborador } from './../entities/colaborador';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Injectable()
export class ColaboradorService {

  colaboradorURL = 'http://localhost:8080/colaborador';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Colaborador[]>(this.colaboradorURL);
  }

  bucarPorId(id: number) {
    return this.http.get<Colaborador[]>(`${this.colaboradorURL}/${id}`);
  }

  atualizar(colaborador) {
    return this.http.put(this.colaboradorURL + '/' + `${colaborador.id}`, colaborador);
  }

  adicionar(colaborador) {
    return this.http.post(this.colaboradorURL, colaborador);
  }

  remover(id) {
    return this.http.delete(this.colaboradorURL + '/' + `${id}`);
  }

}
