import { Endereco } from './endereco';
import { Usuario } from './usuario';

export class Colaborador extends Usuario {
    id: number;
    cargo:string;
    objetivo: string;
    endereco : Endereco = new Endereco();
}
