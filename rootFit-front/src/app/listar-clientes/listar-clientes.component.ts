import { Component, OnInit } from '@angular/core';

import { AlunoService } from '../shared/services/aluno.service';

@Component({
  selector: 'app-listar-clientes',
  templateUrl: './listar-clientes.component.html',
  styleUrls: ['./listar-clientes.component.css']
})
export class ListarClientesComponent implements OnInit {

  alunos: Array<any>;

  constructor( private alunoService: AlunoService) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.alunoService.listar().subscribe( dados => this.alunos = dados);
  }
}
