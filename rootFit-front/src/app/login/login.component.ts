import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { nullSafeIsEquivalent } from '@angular/compiler/src/output/output_ast';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor( private formBuilder: FormBuilder, private http: HttpClient) { }

  ngOnInit() {
      this.loginForm = this.formBuilder.group({
        email: [null],
        senha: [null]
      });
  }
  onSubmit() {
    console.log(this.loginForm.value);

    this.http.post('http://localhost:8080/aluno', JSON.stringify(this.loginForm.value))
    .map(res => res)
    .subscribe(dados => console.log(dados));
  }

}
