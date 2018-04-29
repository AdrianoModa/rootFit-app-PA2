import { Colaborador } from './../entities/colaborador';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthHttp } from 'angular2-jwt';

@Injectable()
export class ColaboradorService {

  colaboradorURL = 'http://localhost:8080/colaborador';

  constructor(private http: AuthHttp) { }

  pesquisar(): Promise<any> {
    const params = new URLSearchParams();

    return this.http.get(`${this.colaboradorURL}`)
      .toPromise()
      .then(response => {
        const responseJson = response.json();
        const colaboradores = responseJson.content;

        const resultado = {
          colaboradores,
          total: responseJson.totalElements
        };

        return resultado;
      });
  }

  /*bucarPorId(id: number) {
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
  }*/

}
