import { ExercicioService } from './../shared/services/exercicio.service';
import { Exercicio } from './../shared/entities/exercicio';
import { Aluno } from './../shared/entities/aluno';
import { AlunoService } from './../shared/services/aluno.service';
import { FichaTreino } from './../shared/entities/ficha-treino';
import { FichaTreinoService } from './../shared/services/ficha-treino.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastrar-ficha-treino',
  templateUrl: './cadastrar-ficha-treino.component.html',
  styleUrls: ['./cadastrar-ficha-treino.component.css']
})
export class CadastrarFichaTreinoComponent implements OnInit {

  fichaTreino: FichaTreino[] = [];
  alunos: Aluno[] = [];
  exercicios: Exercicio[] = [];

  constructor(
    private fichaTreinoService: FichaTreinoService,
    private alunoService: AlunoService,
    private exercicioService: ExercicioService) { }

  ngOnInit() {
    this.consultarFichaTreino();
    this.consultarAluno();
    this.consultarExercicio();
  }

  consultarFichaTreino() {
    this.fichaTreinoService.buscar()
    .subscribe(dados => this.fichaTreino = dados);
  }

  consultarAluno() {
    this.alunoService.buscar()
    .subscribe(dados => this.alunos = dados);
  }

  consultarExercicio() {
    this.exercicioService.buscar()
    .subscribe(dados => this.exercicios = dados);
  }

  remover(fichaTreino){
    if(confirm('Deseja remover a ficha: ' + this.fichaTreino + '?')) {
      const index =this.fichaTreino.indexOf(fichaTreino);
      this.fichaTreino.splice(index, 1);

      this.fichaTreinoService.remover(fichaTreino)
      .subscribe(null,
        err => {
          alert('ficha não removida');
          this.fichaTreino.splice(index, 0, fichaTreino);
        }
      );
    }
  }

}
