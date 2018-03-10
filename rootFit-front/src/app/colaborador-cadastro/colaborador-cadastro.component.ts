import { FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

import { ColaboradorService } from '../shared/services/colaborador.service';

@Component({
  selector: 'app-colaborador-cadastro',
  templateUrl: './colaborador-cadastro.component.html',
  styleUrls: ['./colaborador-cadastro.component.css']
})
export class ColaboradorCadastroComponent implements OnInit {

  colaborador = [];

  constructor(private colaboradorService: ColaboradorService) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
  this.colaboradorService.listar()
  .subscribe(dados => this.colaborador = dados);
  }

  adicionar(frm: FormControl) {
    console.log(frm.value);

    this.colaboradorService.adicionar(frm.value)
    .subscribe(() => {
      frm.reset();
      this.listar();
    });
  }
}
