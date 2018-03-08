import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class LoginService {

  alunoURL = 'http://localhost:8080/aluno';

  constructor( private http: HttpClient) { }

  adicionar(loginForm: any) {
    return this.http.post(this.alunoURL, loginForm);

  }

}
