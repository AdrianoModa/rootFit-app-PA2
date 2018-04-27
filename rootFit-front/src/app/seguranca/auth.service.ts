import { JwtHelper } from 'angular2-jwt';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map';
import'rxjs/Rx';

@Injectable()
export class AuthService {

  oauthTokenUrl = 'http://localhost:8080/oauth/token';
  jwtPayload: any;

  constructor(private http: HttpClient,
              private jwtHelper: JwtHelper
             ) {
               this.carregarToken();
              //  private jwtHelper: JwtHelper
               }

  login(usuario: string, senha: string): Promise<void> {
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/x-www-form-urlencoded');
    headers = headers.append('Authorization', 'Basic YW5ndWxhcjpAbmd1bEByMA==');

    let body = `username=${usuario}&password=${senha}&grant_type=password`;

    return this.http.post(this.oauthTokenUrl, body, { headers })
      .toPromise()
      .then(response => {
        
       // this.armazenarToken(response);
      })
      .catch(response => {
        if (response.status === 400){

          if (response.error === 'invalid_grant') {
            return Promise.reject('Usuário ou senha inválida!');
          }
        }

        return Promise.reject(response);
      });
  }

 private armazenarToken (token: string) {
      this.jwtPayload = this.jwtHelper.decodeToken(token);
      localStorage.setItem('token', token);
  }

  private carregarToken(){
    const token = localStorage.getItem('token');

    if(token) {
      this.armazenarToken(token);    }
  }

}
