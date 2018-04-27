import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  constructor(private auth: AuthService, private router: Router) { }

  login(usuario: string, senha: string) {
    this.auth.login(usuario, senha)
    .catch(erro => {
        if( erro === 'invalid_grant'){
          return Promise.reject('Usuário ou senha inválida!')
        }
        return Promise.reject(erro)
    })
    .then(() => {
        this.router.navigate(['/dashboard']);
    });
  }

}
