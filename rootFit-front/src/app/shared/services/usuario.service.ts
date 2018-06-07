import { Injectable } from '@angular/core';
import { Usuario } from '../entities/usuario';
import { AuthHttp } from 'angular2-jwt';

@Injectable()
export class UsuarioService {

  constructor(private http: AuthHttp) { }

  usuarioURL = 'http://localhost:8080/usuarios'

  adicionar(usuario: Usuario) {
    return this.http.post(this.usuarioURL, usuario);
  }
  
  consultar(): Promise<any> {
    return this.http.get(this.usuarioURL)
      .toPromise()
      .then( response => response.json());
  }

}
