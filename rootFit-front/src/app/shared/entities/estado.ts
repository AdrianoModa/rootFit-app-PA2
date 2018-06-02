import { Cidade } from './cidade';

export class Estado {
    id: number;
    estado: string;
    cidade: Cidade = new Cidade();
  }
  