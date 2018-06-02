import { Injectable } from '@angular/core';
import { AuthHttp } from 'angular2-jwt';

@Injectable()
export class CidadesService {

  cidadesUrl = 'http://localhost:8080/cidade'

  constructor(private http: AuthHttp) { }

  consultar(): Promise<any> {
    return this.http.get(this.cidadesUrl)
      .toPromise()
      .then( response => response.json());
  }

}
