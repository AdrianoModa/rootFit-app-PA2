import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

import { AvaliacaoFisica } from '../../shared/entities/avaliacao-fisica';
import { AvaliacaoFisicaService } from '../../shared/services/avaliacao-fisica.service';

@Component({
  selector: 'app-form-avaliacao-fisica',
  templateUrl: './form-avaliacao-fisica.component.html',
  styleUrls: ['./form-avaliacao-fisica.component.css']
})
export class FormAvaliacaoFisicaComponent implements OnInit {

  avaliacao: AvaliacaoFisica[] = [];

  constructor(private avaliacaoFisicaService: AvaliacaoFisicaService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.consultar();
  }

  consultar(){
    this.avaliacaoFisicaService.buscar()
    .subscribe(dados => this.avaliacao = dados);
  }

  salvar(frm: FormControl){
    this.avaliacaoFisicaService.adicionar(frm.value)
    .subscribe(() => {
      frm.reset()
      this.avaliacaoFisicaService.buscar();
    })
  }

  atualizar(frm: FormControl){
    this.avaliacaoFisicaService.atualizar(frm.value)
    .subscribe(() => {
      frm.reset()
      alert("Seu cadastro foi atualizado com sucesso!");
    })
  }

}
