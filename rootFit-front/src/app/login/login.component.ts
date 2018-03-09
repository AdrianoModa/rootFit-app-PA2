import { AlunoService } from './../shared/services/aluno.service';
import { Aluno } from './../shared/entities/aluno';
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
  aluno: Aluno = new Aluno();

  constructor( private formBuilder: FormBuilder, private alunoService: AlunoService) { }

  ngOnInit() {
      this.loginForm = this.formBuilder.group({
        email: [''],
        senha: ['']
      });
  }
  onSubmit() {
    const alunoData = this.loginForm.value;
    this.alunoService.adicionar(alunoData);
  }

}
