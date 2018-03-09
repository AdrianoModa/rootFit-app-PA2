import { Component, OnInit } from '@angular/core';

import { ListarClientesService } from './listar-clientes.service';


@Component({
  selector: 'app-listar-clientes',
  templateUrl: './listar-clientes.component.html',
  styleUrls: ['./listar-clientes.component.css']
})
export class ListarClientesComponent implements OnInit {

  clientes: Array<any>;

  constructor( private listarClientesService: ListarClientesService) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.listarClientesService.listar().subscribe( dados => this.clientes = dados);
  }
}
