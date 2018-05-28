import { AuthHttp } from 'angular2-jwt';
import { Colaborador } from './../shared/entities/colaborador';
import { Http, RequestOptions } from '@angular/http';
import { Component, OnInit } from '@angular/core';
import { ColaboradorService } from '../shared/services/colaborador.service';
import { ToastyService } from 'ng2-toasty';
import { ErrorHandlerService } from '../shared/services/error-handler.service';
import { FormControl, NgForm } from '@angular/forms';

import 'rxjs/add/operator/map';

@Component({
  selector: 'app-cadastrar-usuario',
  templateUrl: './cadastrar-usuario.component.html',
  styleUrls: ['./cadastrar-usuario.component.css']
})
export class CadastrarUsuarioComponent implements OnInit {

  colaborador = new Colaborador();

  tipo = [
          {id: 1, nome: 'Administrador'},
          {id: 2, nome: 'Colaborador'},
          {id: 3, nome: 'Instrutor'},
          {id: 4, nome: 'Aluno'}
         ];
  tipoAc = "1";

  constructor(private http: Http, 
              private colaboradorService: ColaboradorService,
              private toasty: ToastyService,
              private errorHandle: ErrorHandlerService) { }


  ngOnInit() {
  }

  salvarColaborador( form: NgForm){
      this.colaboradorService.adicionar(this.colaborador)
        .then(() => {
          this.toasty.success('Colaborador cadastrado com sucesso!');
        })
        .catch(
          erro => this.errorHandle.handle(erro)
        );
  }

  salvarAdministrador(){
  }

  salvarAluno(){
  }

  salvarInstrutor(){
  }
}
