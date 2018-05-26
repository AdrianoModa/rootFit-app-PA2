import { Estado } from './estado';

export class Cidade {
    id: number;
    cidade: string;
    estado: Estado = new Estado();
  }
  