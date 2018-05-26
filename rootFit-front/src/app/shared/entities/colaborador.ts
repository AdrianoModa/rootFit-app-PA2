import { Endereco } from './endereco';
import { TipoUsuario } from './tipousuario';
import { Usuario } from './usuario';

export class Colaborador {
  id: number;
  usuario: Usuario = new Usuario();
  cargo:string;
  endereco: Endereco = new Endereco();
  tipoUsuario: TipoUsuario = new TipoUsuario();
}
