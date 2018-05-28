import { Estado } from './estado';
import { Cidade } from './cidade';

export class Endereco {
  logradouro: string;
  numero: string;
  complemento: string;
  bairro: string;
  estado: Estado = new Estado();
  cep: string;
}
