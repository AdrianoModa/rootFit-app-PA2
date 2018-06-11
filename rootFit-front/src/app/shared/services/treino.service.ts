import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class TreinoService {

  fichaTreinoURL = "http://localhost:8080/ficha-treino";

  constructor(private httpCliente: HttpClient) { }

}
