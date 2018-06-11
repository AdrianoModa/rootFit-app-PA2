import { Aluno } from './aluno';
import { Exercicio } from './exercicio';
export class Treino {

    id: number;
    nome: string;
    aluno: Aluno = new Aluno();
    exercicio: Exercicio = new Exercicio();
}
