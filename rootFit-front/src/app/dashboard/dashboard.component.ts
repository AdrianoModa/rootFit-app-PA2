import { AlunoService } from './../shared/services/aluno.service';
import { InstrutorService } from './../shared/services/instrutor.service';
import { ColaboradorService } from './../shared/services/colaborador.service';
import { Component, OnInit } from '@angular/core';
import { Colaborador } from '../shared/entities/colaborador';
import { ErrorHandler } from '@angular/router/src/router';
import { ErrorHandlerService } from '../shared/services/error-handler.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  colaboradores = [];
  instrutores = [];
  alunos = [];

  constructor(private colaboradorService: ColaboradorService,
              private instrutorService: InstrutorService,
              private alunoService: AlunoService, 
              private errorHandler: ErrorHandlerService) { }

  ngOnInit() {
    this.consultarColaborador();
    this.consultarInstrutor();
    this.consultarAluno();
  }

  consultarColaborador() {
   this.colaboradorService.consultar()
      .then(colaboradores => this.colaboradores = colaboradores)
      .catch(erro => this.errorHandler.handle(erro));
  }

  consultarAluno() {
    this.alunoService.consultar()
       .then(alunos => this.alunos = alunos)
       .catch(erro => this.errorHandler.handle(erro));
   }
   consultarInstrutor() {
    this.instrutorService.consultar()
       .then(instrutores => this.instrutores = instrutores)
       .catch(erro => this.errorHandler.handle(erro));
   }

  

}
