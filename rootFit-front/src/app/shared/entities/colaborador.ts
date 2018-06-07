import { Endereco } from './endereco';
import { Usuario } from './usuario';
import { TipoUsuario } from './tipousuario';

export class Colaborador extends Usuario {
    id: number;
    cargo:string;
    objetivo: string;
    tipoUsuario: TipoUsuario = new TipoUsuario();
}
