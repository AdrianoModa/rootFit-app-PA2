import { Usuario } from "./usuario";
import { Endereco } from "./endereco";
import { TipoUsuario } from "./tipousuario";

export class Aluno {
  id: number;
  usuario: Usuario = new Usuario();
  status: boolean;
	objetivo: string;
	nascimento: Date;
  inicio: Date;
  endereco: Endereco = new Endereco();
  tipoUsuario: TipoUsuario = new TipoUsuario();
}
