import { Estado } from './estado';

export class Endereco {
  logradouro: string;
  numero: string;
  complemento: string;
  bairro: string;
  estado: Estado = new Estado();
  cep: string;
}
