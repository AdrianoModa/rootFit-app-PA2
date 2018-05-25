import { AuthHttp } from 'angular2-jwt';
import { Colaborador } from './../shared/entities/colaborador';
import { Http, RequestOptions } from '@angular/http';
import { Component, OnInit } from '@angular/core';
import { ColaboradorService } from '../shared/services/colaborador.service';
import { ToastyService } from 'ng2-toasty';
import { ErrorHandlerService } from '../shared/services/error-handler.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-cadastrar-usuario',
  templateUrl: './cadastrar-usuario.component.html',
  styleUrls: ['./cadastrar-usuario.component.css']
})
export class CadastrarUsuarioComponent implements OnInit {

  colaborador = new Colaborador();

  constructor(private http: AuthHttp, 
              private colaboradorService: ColaboradorService,
              private toasty: ToastyService,
              private errorHandle: ErrorHandlerService) { }


  ngOnInit() {
  }

  salvarColaborador(form: FormControl){
      this.colaboradorService.adicionar(this.colaborador)
        .then(() => {
            this.toasty.success('Usuário cadastrado com sucesso!');

            form.reset();
        })
        .catch(erro => this.errorHandle.handle(erro))
  }

}
