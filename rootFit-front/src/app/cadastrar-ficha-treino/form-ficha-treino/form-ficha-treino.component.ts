import { FichaTreinoService } from './../../shared/services/ficha-treino.service';
import { FichaTreino } from './../../shared/entities/ficha-treino';
import { Router, ActivatedRoute } from '@angular/router';
import { InstrutorService } from './../../shared/services/instrutor.service';
import { AlunoService } from './../../shared/services/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Aluno } from '../../shared/entities/aluno';
import { Instrutor } from '../../shared/entities/instrutor';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-form-ficha-treino',
  templateUrl: './form-ficha-treino.component.html',
  styleUrls: ['./form-ficha-treino.component.css']
})
export class FormFichaTreinoComponent implements OnInit {

  fichaTreino: FichaTreino[] = [];
  alunos: Aluno[] = [];
  instrutores: Instrutor[] = [];

  constructor(
    private fichaTreinoService: FichaTreinoService,
    private alunoService: AlunoService,
    private InstrutorService: InstrutorService,
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.consultar();
    this.consultarAluno();
    this.consultarInstrutor();
    var id = this.route.params.subscribe(params => {
      var id = params['id'];

      this.fichaTreinoService.buscarPorId(id)
        .subscribe(
          avaliacao => this.fichaTreino = avaliacao,          
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
    this.fichaTreinoService.buscar()
    .subscribe(dados => this.fichaTreino = dados);
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
    this.fichaTreinoService.buscarPorId(frm.value)
    .subscribe(dados => this.fichaTreino = dados)
  }

  salvar(frm: FormControl){
    if(this.editando){
      return this.atualizar(frm);
    }else{
      return this.adicionar(frm);
    }
  }

  adicionar(frm: FormControl){
    this.fichaTreinoService.adicionar(frm.value)
    .subscribe(dados  => {
      frm.reset()
      alert("Avaliacao Gerada com Sucesso!");
      this.router.navigate(['avaliacao-fisica']);
    })
  }

  atualizar(frm: FormControl){
    this.fichaTreinoService.atualizar(this.fichaTreino)
    .subscribe(() => {
      frm.reset()
      alert("Seu cadastro foi atualizado com sucesso!");
      this.router.navigate(['avaliacao-fisica'])
    })
  }

}
