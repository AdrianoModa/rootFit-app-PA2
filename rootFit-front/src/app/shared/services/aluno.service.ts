import { Injectable } from '@angular/core';

import { AuthHttp } from 'angular2-jwt';

@Injectable()
export class AlunoService {

  alunoURL = 'http://localhost:3000/alunos';

  constructor(private http: AuthHttp) { }

  consultar(): Promise<any> {
    return this.http.get(this.alunoURL)
      .toPromise()
      .then( response => response.json());
  }
}
