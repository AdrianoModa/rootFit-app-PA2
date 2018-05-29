import { Router, ActivatedRoute } from '@angular/router';
import { InstrutorService } from './../../shared/services/instrutor.service';
import { AlunoService } from './../../shared/services/aluno.service';
import { Component, OnInit } from '@angular/core';
import { AvaliacaoFisica } from '../../shared/entities/avaliacao-fisica';
import { Aluno } from '../../shared/entities/aluno';
import { Instrutor } from '../../shared/entities/instrutor';
import { AvaliacaoFisicaService } from '../../shared/services/avaliacao-fisica.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-form-ficha-treino',
  templateUrl: './form-ficha-treino.component.html',
  styleUrls: ['./form-ficha-treino.component.css']
})
export class FormFichaTreinoComponent implements OnInit {

  avaliacoes: AvaliacaoFisica[] = [];
  alunos: Aluno[] = [];
  instrutores: Instrutor[] = [];

  constructor(
    private avaliacaoFisicaService: AvaliacaoFisicaService,
    private alunoService: AlunoService,
    private InstrutorService: InstrutorService,
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.consultar();
    this.consultarAluno();
    this.consultarInstrutor();
    var id = this.route.params.subscribe(params => {
      var id = params['id'];

      this.avaliacaoFisicaService.buscarPorId(id)
        .subscribe(
          avaliacao => this.avaliacoes = avaliacao,          
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
    .subscribe(dados => this.avaliacoes = dados);
  }

  consultarAluno(){
    this.alunoService.buscar()
    .subscribe(dados => this.alunos = dados);
  }

  consultarInstrutor(){
    this.InstrutorService.buscar()
    .subscribe(dados => this.instrutores = dados);
  }

  consultarPorId(frm: FormControl){
    this.avaliacaoFisicaService.buscarPorId(frm.value)
    .subscribe(dados => this.avaliacoes = dados)
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
    this.avaliacaoFisicaService.atualizar(this.avaliacoes)
    .subscribe(() => {
      frm.reset()
      alert("Seu cadastro foi atualizado com sucesso!");
      this.router.navigate(['avaliacao-fisica'])
    })
  }

}
