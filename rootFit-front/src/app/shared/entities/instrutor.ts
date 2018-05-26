import { Usuario } from "./usuario";
import { Endereco } from "./endereco";
import { TipoUsuario } from "./tipousuario";

export class Instrutor {
  id: number;
  usuario: Usuario = new Usuario();
  endereco: Endereco = new Endereco();
  tipoUsuario: TipoUsuario = new TipoUsuario();
}
