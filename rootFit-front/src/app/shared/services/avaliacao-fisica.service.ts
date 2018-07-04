import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/toPromise'

@Injectable()
export class AvaliacaoFisicaService {

  // avaliacaoURL = 'http://localhost:3000/avaliacaofisica';

  constructor(private http: Http) { }

    consultar(): Promise<any> {
      return this.http.get('http://localhost:3000/avaliacoes-fisicas')
        .toPromise()
        .then(response => response.json());
    }

  }
