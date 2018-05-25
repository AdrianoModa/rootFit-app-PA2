import { ToastyService } from 'ng2-toasty';
import { Colaborador } from './../shared/entities/colaborador';
import { Component, OnInit } from '@angular/core';

import { ColaboradorService } from '../shared/services/colaborador.service';
import { ErrorHandlerService } from '../shared/services/error-handler.service';

@Component({
  selector: 'app-colaborador',
  templateUrl: './colaborador.component.html',
  styleUrls: ['./colaborador.component.css']
})
export class ColaboradorComponent implements OnInit {

  //colaboradores: Colaborador[] = [];

  colaboradores= [];

  constructor( private colaboradorService: ColaboradorService, 
              private errorHandler: ErrorHandlerService,
              private toasty: ToastyService ) { }

  ngOnInit() {
    this.consultar();
  }

  consultar() {
   this.colaboradorService.consultar()
      .then(colaboradores => this.colaboradores = colaboradores)
      .catch(erro => this.errorHandler.handle(erro));
  }

  deletarUsuario(colaborador){
    if (confirm("tem certeza que quer remover " + colaborador.nome + "?")) {
      var index = this.colaboradores.indexOf(colaborador);
      this.colaboradores.splice(index, 1);

      this.colaboradorService.excluir(colaborador.id)
      .then(() => {
        this.toasty.success('Pesssoa excluída com sucesso!');
      })
      .catch(erro => this.errorHandler.handle(erro));
      };
  }
}
