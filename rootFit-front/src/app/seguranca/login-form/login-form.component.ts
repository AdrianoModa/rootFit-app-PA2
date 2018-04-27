import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  loginForm: FormGroup;

  constructor( private formBuilder: FormBuilder, private http: HttpClient) { }

  ngOnInit() {
      this.loginForm = this.formBuilder.group({
        email: [''],
        senha: ['']
      });
  }
  onSubmit() {
  }

}
