import { Component, OnInit } from '@angular/core';

import { Colaborador } from '../shared/entities/colaborador';
import { ColaboradorService } from '../shared/services/colaborador.service';

@Component({
  selector: 'app-colaborador',
  templateUrl: './colaborador.component.html',
  styleUrls: ['./colaborador.component.css']
})
export class ColaboradorComponent implements OnInit {

  // colaboradores: Colaborador[] = [];

  colaboradores= [];

  constructor( private colaboradorService: ColaboradorService ) { }

  ngOnInit() {
    this.consultar();
  }

  consultar(){
    this.colaboradorService.consultar()
      .then(() => null);
  }

  /*adicionarNovo(){
    this.colaboradorService.adicionar(Colaborador)
    .then(colaborador => {
      alert(`Colaborador "${colaborador.nome}", adicionado com a matrícula "${colaborador.matricula}"!`);
      this.consultarTodos();
    })
  }*/

  

  /*remover(colaboradores) {
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
  }*/

}
