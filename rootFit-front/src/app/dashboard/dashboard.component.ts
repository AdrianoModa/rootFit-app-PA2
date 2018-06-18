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


  alunos = [];

  constructor(private alunoService: AlunoService, 
              private errorHandler: ErrorHandlerService) { }

  ngOnInit() {
    this.consultarAluno();
  }



  consultarAluno() {
    this.alunoService.consultar()
       .then(alunos => this.alunos = alunos)
       .catch(erro => this.errorHandler.handle(erro));
   }
}
