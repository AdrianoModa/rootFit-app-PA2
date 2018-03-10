<<<<<<< HEAD
import { HttpClient, HttpParams } from '@angular/common/http';
=======
import { AlunoService } from './../shared/services/aluno.service';
import { Aluno } from './../shared/entities/aluno';
import { HttpClient } from '@angular/common/http';
>>>>>>> ffd4a7401758ea01b612d892e36d37ada69fa280
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
  aluno: Aluno = new Aluno();

  constructor( private formBuilder: FormBuilder, private alunoService: AlunoService) { }

  ngOnInit() {
      this.loginForm = this.formBuilder.group({
        email: [''],
        senha: ['']
      });
  }
  onSubmit() {
    console.log(this.loginForm.value);
    // let headers = new Headers({'Content-type': 'application/json'});
    // let body = JSON.stringify(this.loginForm.value);
    // let options: any = new RequestOptions({ headers: hearders});
    this.http.post('http://localhost:8080/aluno/aluno', JSON.stringify(this.loginForm.value)).subscribe(dados => console.log(dados));
  }

}
