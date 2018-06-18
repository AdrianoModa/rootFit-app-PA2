import { Component, OnInit } from '@angular/core';
import { Colaborador } from '../../shared/entities/colaborador';
import { Usuario } from '../../shared/entities/usuario';
import { TipoUsuario } from '../../shared/entities/tipousuario';
import { ToastyService } from 'ng2-toasty';
import { ErrorHandlerService } from '../../shared/services/error-handler.service';
import { Http } from '@angular/http';

@Component({
  selector: 'app-form-aluno',
  templateUrl: './form-aluno.component.html',
  styleUrls: ['./form-aluno.component.css']
})
export class FormAlunoComponent implements OnInit {

  usuario = new Usuario();

  private usuarios = [
    { value: '', label: '' }
  ]

  private estados = [
    { value: null, label: null }
  ];

  private cidades = [
    { value: null, label: null }
  ];

  private generos = [
    { value : 1 , label : "Feminino" },
    { value : 2 , label : "Masculino" },
    { value : 3 , label : "Outro" }
  ];

  private status = [
    { value : true , label : "Ativo" },
    { value : false , label : "Inativo" }
  ];

  constructor(private http: Http, 
              private toasty: ToastyService,
              private errorHandle: ErrorHandlerService
            ) { }


  ngOnInit() {
   
  }

  
  
}
