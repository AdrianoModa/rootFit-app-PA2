import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-colaborador-cadastro',
  templateUrl: './colaborador-cadastro.component.html',
  styleUrls: ['./colaborador-cadastro.component.css']
})
export class ColaboradorCadastroComponent implements OnInit {

  colaboradores = [
    { nome: '', email: '', senha: '', telefone: ''},
    { nome: '', email: '', senha: '', telefone: ''},
    { nome: '', email: '', senha: '', telefone: ''}
  ];

  constructor() { }

  ngOnInit() {
  }

}
