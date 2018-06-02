import { CidadesService } from './../shared/services/cidades.service';
import { EstadosService } from './../shared/services/estados.service';
import { Router } from '@angular/router';
import { FormControl, NgForm, NgModel } from '@angular/forms';
import { Http, RequestOptions } from '@angular/http';
import { Component, OnInit } from '@angular/core';

import { ToastyService } from 'ng2-toasty';
import { AuthHttp } from 'angular2-jwt';

import { Colaborador } from './../shared/entities/colaborador';
import { TipoUsuario } from './../shared/entities/tipousuario';
import { TipoUsuarioService } from './../shared/services/tipo-usuario.service';
import { ColaboradorService } from '../shared/services/colaborador.service';
import { ErrorHandlerService } from '../shared/services/error-handler.service';

import 'rxjs/add/operator/map';
import { map } from 'rxjs/operator/map';

@Component({
  selector: 'app-cadastrar-usuario',
  templateUrl: './cadastrar-usuario.component.html',
  styleUrls: ['./cadastrar-usuario.component.css']
})
export class CadastrarUsuarioComponent implements OnInit {

  colaborador = new Colaborador();

  private tipos = [
    { value: null, label: null }
  ];

  private estados = [
    { value: null, label: null }
  ];

  private cidades = [
    { value: null, label: null }
  ];

  private generos = [
    { value : 1 , label : "Feminino" },
    { value : 2 , label : "Masculino" },
    { value : 3 , label : "Outro" }
  ];

  private status = [
    { value : true , label : "Ativo" },
    { value : false , label : "Inativo" }
  ];

  private cargos = [
    { value : 1 , label : "Recepcionista" },
    { value : 2 , label : "Gerente" },
    { value : 3 , label : "Supervisor"}
  ];

  private instrutores = [
    { value : 1 , label : "Michel temer" },
    { value : 2 , label : "Pedro Parente" },
    { value : 3 , label : "Dilma Roussef" },
    { value : 4 , label : "Jair Bozonaro"}
  ];

  constructor(private http: Http, 
              private colaboradorService: ColaboradorService,
              private tipoUsuarioService: TipoUsuarioService,
              private estadosService: EstadosService,
              private cidadesService: CidadesService,
              private toasty: ToastyService,
              private errorHandle: ErrorHandlerService,
              private route: Router) { }


  ngOnInit() {
    this.consultarTipoUsuario();
    this.consultarEstados();
    this.consultarCidades();
  }


  consultarEstados(){
    this.estadosService.consultar()
    .then(estados => this.estados = estados.map(e => {
      return {label: e.estado, value: e.id  };
    }))
    .catch(erro => this.errorHandle.handle(erro));
  }

  consultarCidades(){
    this.cidadesService.consultar()
    .then(cidades => this.cidades = cidades.map(c => {
      return {label: c.cidade, value: c.id  };
    }))
    .catch(erro => this.errorHandle.handle(erro));
  }

  consultarTipoUsuario(){
    this.tipoUsuarioService.consultar()
    .then(tipos => this.tipos = tipos.map(t => {
      return {label: t.descricao, value: t.id  };
    }))
    .catch(erro => this.errorHandle.handle(erro));
  }

  salvarColaborador(frm: FormControl){
    this.colaboradorService.adicionar(this.colaborador)
    .subscribe(dados  => {
      frm.reset()
      this.toasty.success('Colaborador cadastrado com sucessso!')
      //this.route.navigate(['avaliacao-fisica']);
    })
  }


  salvarAdministrador(){
  }

  // salvarAluno(){
  //   this.colaboradorService.adicionar(this.colaborador)
  //       .then(() => {
  //         this.toasty.success('Colaborador cadastrado com sucesso!');
  //       })
  //       .catch(
  //         erro => this.errorHandle.handle(erro)
  //       );
  // }

  salvarInstrutor(){
  }
}
