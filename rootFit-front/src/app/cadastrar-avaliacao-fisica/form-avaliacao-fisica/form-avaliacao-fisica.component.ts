import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { AvaliacaoFisica } from '../../shared/entities/avaliacao-fisica';
import { AvaliacaoFisicaService } from '../../shared/services/avaliacao-fisica.service';
import { CadastrarUsuarioComponent } from '../../cadastrar-usuario/cadastrar-usuario.component';

@Component({
  selector: 'app-form-avaliacao-fisica',
  templateUrl: './form-avaliacao-fisica.component.html',
  styleUrls: ['./form-avaliacao-fisica.component.css']
})
export class FormAvaliacaoFisicaComponent implements OnInit {

  avaliacao: AvaliacaoFisica[] = [];

  constructor(
    private avaliacaoFisicaService: AvaliacaoFisicaService,
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.consultar();
    console.log(this.consultar());
    var id = this.route.params.subscribe(params => {
      var id = params['id'];

      this.avaliacaoFisicaService.buscarPorId(id)
        .subscribe(
          avaliacao => this.avaliacao = avaliacao,
          response => {
            if (response.status == 404) {
              this.router.navigate(['Não Encontrado']);
            }
          });
    });
  }

  get editando(){
    return Boolean (this.route.snapshot.params['id']);
  }

  consultar(){
    this.avaliacaoFisicaService.buscar()
    .subscribe(dados => this.avaliacao = dados);
  }

  consultarPorId(frm: FormControl){
    this.avaliacaoFisicaService.buscarPorId(frm.value)
    .subscribe(dados => this.avaliacao = dados)
  }

  salvar(frm: FormControl){
    if(this.editando){
      return this.atualizar(frm);
    }else{
      return this.adicionar(frm);
    }
  }

  adicionar(frm: FormControl){
    this.avaliacaoFisicaService.adicionar(frm.value)
    .subscribe(dados  => {
      frm.reset()
      alert("Avaliacao Gerada com Sucesso!");
      this.router.navigate(['avaliacao-fisica']);
    })
  }

  atualizar(frm: FormControl){
    this.avaliacaoFisicaService.atualizar(this.avaliacao)
    .subscribe(() => {
      frm.reset()
      alert("Seu cadastro foi atualizado com sucesso!");
      this.router.navigate(['avaliacao-fisica'])
    })
  }

}