import { Colaborador } from './../shared/entities/colaborador';
import { FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

import { ColaboradorService } from '../shared/services/colaborador.service';

@Component({
  selector: 'app-colaborador-cadastro',
  templateUrl: './colaborador-cadastro.component.html',
  styleUrls: ['./colaborador-cadastro.component.css']
})
export class ColaboradorCadastroComponent implements OnInit {

  colaboradores: Colaborador[] = [];

  constructor(private colaboradorService: ColaboradorService) { }

  ngOnInit(): void {

    this.listar();

  }

  listar() {
    this.colaboradorService.listar()
    .subscribe(data => this.colaboradores = data);
  }

  adicionar(frm: FormControl) {
    console.log(frm.value);

    this.colaboradorService.adicionar(frm.value)
    .subscribe(() => {
      frm.reset();
      this.listar();
    });
  }

  remover(colaboradores) {
    if (confirm('Deseja remover o colaborador:  ' + colaboradores.nome + '?')) {
      const index = this.colaboradores.indexOf(colaboradores);
      this.colaboradores.splice(index, 1);

      this.colaboradorService.remover(colaboradores.id)
        .subscribe(null,
          err => {
            alert('Colaborador não removido.');
            // Revert the view back to its original state
            this.colaboradores.splice(index, 0, colaboradores);
          });

    }
}
}
