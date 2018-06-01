import { Injectable } from '@angular/core';
import { AuthHttp } from 'angular2-jwt';

@Injectable()
export class TipoUsuarioService {

  tipoUsuarioUrl = "http://localhost:8080/tipo-usuario";

  constructor(private http: AuthHttp) { }

  consultar(): Promise<any> {
    return this.http.get(this.tipoUsuarioUrl)
      .toPromise()
      .then( response => response.json());
  }

}
