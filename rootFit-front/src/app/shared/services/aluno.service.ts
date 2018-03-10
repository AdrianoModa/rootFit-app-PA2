import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AlunoService {

  alunoURL = 'http://localhost:8080/aluno';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any[]>(`${this.alunoURL}`);
  }

  adicionar(aluno){
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let body = JSON.stringify(aluno);
    this.http.post(this.alunoURL + '/' + aluno.email + '/' + aluno.senha, body)
    .map(res => res)
    .subscribe(dados => console.log(dados));
  }

}
