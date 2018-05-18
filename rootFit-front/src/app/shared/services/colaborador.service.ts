import { Http, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthHttp } from 'angular2-jwt';
import 'rxjs/add/operator/toPromise'
import { promise } from 'protractor';

@Injectable()
export class ColaboradorService {

  colaboradorUrl = 'http://localhost:8080/colaborador';

  constructor(private http: Http) { }

  consultar(): Promise<any> {
    const headers = new Headers();
    headers.append('Authorization','Basic YW5ndWxhcjpAbmd1bEByMA==');

    return this.http.get(`${this.colaboradorUrl}`, {headers} )
      .toPromise()
      .then(response => {
        console.log(response.json());
      })
  }
  
  
  
  
  /*consultar(): Promise<any>{
    return this.http.get(this.colaboradorUrl)
      .toPromise()
      .then(response => response.json());

  }*/


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
