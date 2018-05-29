import { Aluno } from './aluno';
import { Exercicio } from './exercicio';
export class FichaTreino {

    id: number;
    nome: string;
    aluno: Aluno = new Aluno();
    exercicio: Exercicio = new Exercicio();
}
