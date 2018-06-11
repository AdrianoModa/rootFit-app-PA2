import { ToastyService } from 'ng2-toasty';
import { Component, OnInit } from '@angular/core';

import { ColaboradorService } from '../shared/services/colaborador.service';
import { ErrorHandlerService } from '../shared/services/error-handler.service';

@Component({
  selector: 'app-aluno',
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.css']
})
export class AlunoComponent implements OnInit {

  //colaboradores: Colaborador[] = [];

  colaboradores= [];

  constructor( 
              private errorHandler: ErrorHandlerService,
              private toasty: ToastyService ) { }

  ngOnInit() {
  }
}
