import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Instrutor } from './../entities/instrutor';
import { AuthHttp } from 'angular2-jwt';

@Injectable()
export class InstrutorService {

  instrutorURL = 'http://localhost:8080/instrutor'

  constructor(private http: AuthHttp) { }

  consultar(): Promise<any> {
    return this.http.get(this.instrutorURL)
      .toPromise()
      .then( response => response.json());
  }

}
