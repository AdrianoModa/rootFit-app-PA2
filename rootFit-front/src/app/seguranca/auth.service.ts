import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class AuthService {

  oauthTokenUrl = 'http://localhost:8080/oauth/token';
  
  constructor(private http: HttpClient){ 

  }

  login(usuario: string, senha: string): Promise<void> {
    const headers = new HttpHeaders();
    headers.append('Content-type','application/x-www-form-urlencoded');
    headers.append('Authorization','Basic YW5ndWxhcjpAbmd1bEByMA==');

    const body = `username=${usuario}&password${senha}&grant_type=password`;

    return this.http.post(this.oauthTokenUrl, body, { headers })
      .toPromise()
      .then(response => {
        console.log(response);
      })
      .catch(response => {
        console.log(response);
      })  
  }

}
