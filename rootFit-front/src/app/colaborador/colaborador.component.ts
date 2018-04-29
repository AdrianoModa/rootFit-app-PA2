import { Component, OnInit } from '@angular/core';
import { Colaborador } from '../shared/entities/colaborador';
import { ColaboradorService } from '../shared/services/colaborador.service';

@Component({
  selector: 'app-colaborador',
  templateUrl: './colaborador.component.html',
  styleUrls: ['./colaborador.component.css']
})
export class ColaboradorComponent implements OnInit {

  colaboradores: Colaborador[] = [];

  lancamentos = [];

  constructor( private colaboradorService: ColaboradorService ) { }

  ngOnInit() {
    this.pesquisar();
  }

  pesquisar() {

    this.colaboradorService.pesquisar()
      .then(resultado => {
        this.lancamentos = resultado.lancamentos;
      })
  }

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
