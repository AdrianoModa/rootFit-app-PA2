import { AuthHttp } from 'angular2-jwt';
import { Injectable } from '@angular/core';

@Injectable()
export class EstadosService {

  estadosUrl = 'http://localhost:8080/estado'

  constructor(private http: AuthHttp) { }

  consultar(): Promise<any> {
    return this.http.get(this.estadosUrl)
      .toPromise()
      .then( response => response.json());
  }

}
