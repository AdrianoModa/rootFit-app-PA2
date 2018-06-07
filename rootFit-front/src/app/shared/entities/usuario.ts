import { Endereco } from "./endereco";
import { TipoUsuario } from "./tipousuario";

export class Usuario{
    id: number;
    cpf: string;
    email: string;
    datanasc:string;
    genero: string;
    login: string;
    matricula: string;
    endereco : Endereco = new Endereco();
    nome: string;
    senha: string;
    rg: string;
    telefone: string;
    status: boolean;    
  }
  