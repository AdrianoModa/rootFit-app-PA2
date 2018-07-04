import { Component, OnInit } from '@angular/core';
import { AvaliacaoFisicaService } from '../shared/services/avaliacao-fisica.service';

@Component({
  selector: 'app-avaliacao-fisica',
  templateUrl: './avaliacao-fisica.component.html',
  styleUrls: ['./avaliacao-fisica.component.css']
})
export class AvaliacaoFisicaComponent implements OnInit {

  avaliacoesfisicas = [];

  constructor( private avaliacaoFisicaService: AvaliacaoFisicaService ) { }

  ngOnInit() {
    this.consultar();
  }
            
  consultar() {
   this.avaliacaoFisicaService.consultar()
      .then(dados => {
        this.avaliacoesfisicas = dados;
      });
  }

}
