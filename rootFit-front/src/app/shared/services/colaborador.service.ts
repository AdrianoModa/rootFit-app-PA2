import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ColaboradorService {

  colaboradorURL = 'http://localhost:8080/colaborador';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any[]>(this.colaboradorURL);
  }

  adicionar(colaborador: any) {
    return this.http.post(this.colaboradorURL, colaborador);
  }

}
