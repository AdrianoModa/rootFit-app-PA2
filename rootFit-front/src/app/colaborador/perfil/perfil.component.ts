import { ColaboradorService } from './../../shared/services/colaborador.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  colaboradores= [];

  constructor(private colaboradorService: ColaboradorService) { }

  ngOnInit() {
    this.consultarTodos();
  }

  consultarTodos(){
    this.colaboradorService.consultar()
    .then(dados => {
      this.colaboradores = dados;
    });
  }

}
