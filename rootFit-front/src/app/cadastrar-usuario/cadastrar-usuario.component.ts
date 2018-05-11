import { Colaborador } from './../shared/entities/colaborador';
import { Http } from '@angular/http';
import { Component, OnInit } from '@angular/core';
import { ColaboradorService } from '../shared/services/colaborador.service';

@Component({
  selector: 'app-cadastrar-usuario',
  templateUrl: './cadastrar-usuario.component.html',
  styleUrls: ['./cadastrar-usuario.component.css']
})
export class CadastrarUsuarioComponent implements OnInit {

  colaborador = new Colaborador();

  constructor(private http: Http, 
              private colaboradorService: ColaboradorService) { }


  ngOnInit() {
  }

  adicionarNovoColaborador(Colaborador){
    this.colaboradorService.adicionar(Colaborador)
      .then( colaborador => {
        alert(`${colaborador.tipo}: "${colaborador.nome}" foi adicionado com a matricula "${colaborador.matricula}"! `);
      })
  }

}
