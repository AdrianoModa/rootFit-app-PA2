import { Instrutor } from "./instrutor";
import { Aluno } from './aluno';

export class AvaliacaoFisica {
    
    id: number;
    peso: number;
    altura: number;
    dataAvaliacao: string;

    aluno: Aluno = new Aluno();
    instrutor: Instrutor = new Instrutor();

}