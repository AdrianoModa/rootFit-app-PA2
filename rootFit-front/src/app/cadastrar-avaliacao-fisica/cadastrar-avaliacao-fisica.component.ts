import { Instrutor } from './../shared/entities/instrutor';
import { AvaliacaoFisicaService } from './../shared/services/avaliacao-fisica.service';
import { AvaliacaoFisica } from './../shared/entities/avaliacao-fisica';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastrar-avaliacao-fisica',
  templateUrl: './cadastrar-avaliacao-fisica.component.html',
  styleUrls: ['./cadastrar-avaliacao-fisica.component.css']
})
export class CadastrarAvaliacaoFisicaComponent implements OnInit {

  avaliacaoFisica: AvaliacaoFisica[] = [];

  constructor(private avaliacaoFisicaService: AvaliacaoFisicaService) { }

  ngOnInit() {
    this.consultar();
  }

  consultar(){
    this.avaliacaoFisicaService.buscar()
    .subscribe(dados => this.avaliacaoFisica = dados);
  }

  remover(avaliacaoFisica){
    if (confirm('Deseja remover a avaliacao:  ' + avaliacaoFisica.peso + '?')) {
      const index = this.avaliacaoFisica.indexOf(avaliacaoFisica);
      this.avaliacaoFisica.splice(index, 1);
  
      this.avaliacaoFisicaService.remover(avaliacaoFisica)
        .subscribe(null,
          err => {
            alert('Colaborador não removido.');
            // Revert the view back to its original state
            this.avaliacaoFisica.splice(index, 0, avaliacaoFisica);
      });
    }
  } 

}
