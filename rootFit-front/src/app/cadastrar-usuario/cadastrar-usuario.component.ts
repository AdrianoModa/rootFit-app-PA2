import { TipoUsuario } from './../shared/entities/tipousuario';
import { TipoUsuarioService } from './../shared/services/tipo-usuario.service';
import { Router } from '@angular/router';
import { AuthHttp } from 'angular2-jwt';
import { Colaborador } from './../shared/entities/colaborador';
import { Http, RequestOptions } from '@angular/http';
import { Component, OnInit } from '@angular/core';
import { ColaboradorService } from '../shared/services/colaborador.service';
import { ToastyService } from 'ng2-toasty';
import { ErrorHandlerService } from '../shared/services/error-handler.service';
import { FormControl, NgForm, NgModel } from '@angular/forms';

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

  constructor(private http: Http, 
              private colaboradorService: ColaboradorService,
              private tipoUsuarioService: TipoUsuarioService,
              private toasty: ToastyService,
              private errorHandle: ErrorHandlerService,
              private route: Router) { }


  ngOnInit() {

    this.tipoUsuarioService.consultar()
    .then(tipos => this.tipos = tipos.map(t => {
      return {label: t.descricao, value: t.id  };
    }))
    .catch(erro => this.errorHandle.handle(erro));


  }

  // salvarColaborador( form: NgModel){
  //   this.colaboradorService.adicionar(this.colaborador)
  //   .then(colaboradorAdicionado => {
  //     this.toasty.success('Colaborador adicionado com sucesso!');

  //     // form.reset();
  //     // this.lancamento = new Lancamento();
  //   })
  //   .catch(erro => this.errorHandle.handle(erro));
  // }

  salvarColaborador(frm: FormControl){
    this.colaboradorService.adicionar(this.colaborador)
    .subscribe(dados  => {
      frm.reset()
      alert("Avaliacao Gerada com Sucesso!");
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
