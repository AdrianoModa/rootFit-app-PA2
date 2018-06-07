import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Aluno } from './../entities/aluno';
import { AuthHttp } from 'angular2-jwt';

@Injectable()
export class AlunoService {

  alunoURL = 'http://localhost:8080/aluno';

  constructor(private http: AuthHttp) { }

  consultar(): Promise<any> {
    return this.http.get(this.alunoURL)
      .toPromise()
      .then( response => response.json());
  }

  

}
