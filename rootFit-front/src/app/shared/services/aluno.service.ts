import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/toPromise'

@Injectable()
export class AlunoService {

 // alunoURL = 'http://localhost:3000/alunos';

  constructor(private http: Http) { }

  consultar(): Promise<any> {
    return this.http.get('http://localhost:3000/alunos')
      .toPromise()
      .then(response => response.json());
  }
}
