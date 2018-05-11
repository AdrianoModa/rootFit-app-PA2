import { Http, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthHttp } from 'angular2-jwt';
import 'rxjs/add/operator/toPromise'

@Injectable()
export class ColaboradorService {

  colaboradorUrl = 'http://localhost:3000/colaboradores';

  constructor(private http: Http) { }

  consultar(): Promise<any>{
    return this.http.get(this.colaboradorUrl)
      .toPromise()
      .then(response => response.json());

  }

  adicionar(colaborador: any): Promise<any>{
      return this.http.post(this.colaboradorUrl, colaborador)
        .toPromise()
        .then(response => response.json());
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
