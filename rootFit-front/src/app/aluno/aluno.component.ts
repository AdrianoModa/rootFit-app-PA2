import { ToastyService } from 'ng2-toasty';
import { Component, OnInit } from '@angular/core';

import { ErrorHandlerService } from '../shared/services/error-handler.service';
import { AlunoService } from '../shared/services/aluno.service';

@Component({
  selector: 'app-aluno',
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.css']
})
export class AlunoComponent implements OnInit {


  alunos = [];

  constructor(private alunoService: AlunoService,
              private errorHandler: ErrorHandlerService,
              private toasty: ToastyService ) { }

  ngOnInit() {
    this.consultar();
  }
            
  consultar() {
   this.alunoService.consultar()
      .then(dados => {
        this.alunos = dados;
      })
  }
}
