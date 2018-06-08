import { Component, OnInit } from '@angular/core';
import { Colaborador } from '../../shared/entities/colaborador';
import { ColaboradorService } from '../../shared/services/colaborador.service';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../../shared/entities/usuario';
import { TipoUsuario } from '../../shared/entities/tipousuario';
import { TipoUsuarioService } from '../../shared/services/tipo-usuario.service';
import { EstadosService } from '../../shared/services/estados.service';
import { CidadesService } from '../../shared/services/cidades.service';
import { UsuarioService } from '../../shared/services/usuario.service';
import { ToastyService } from 'ng2-toasty';
import { ErrorHandlerService } from '../../shared/services/error-handler.service';
import { Http } from '@angular/http';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  colaborador = new Colaborador();
  usuario = new Usuario();
  tipoUsuario = new TipoUsuario();
  colaboradorId: Colaborador[] = [];

  private usuarios = [
    { value: '', label: '' }
  ]

  private colaboradores = [
    { value: '', label: ''}
  ]

  private tipos = [
    { value : 1 , label : "ADMIN" },
    { value : 2 , label : "USER" }
  ];

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

  private cargos = [
    { value : 1 , label : "Recepcionista" },
    { value : 2 , label : "Gerente" },
    { value : 3 , label : "Supervisor"}
  ];

  private instrutores = [
    { value : 1 , label : "Michel temer" },
    { value : 2 , label : "Pedro Parente" },
    { value : 3 , label : "Dilma Roussef" },
    { value : 4 , label : "Jair Bozonaro"}
  ];

  constructor(private http: Http, 
              private colaboradorService: ColaboradorService,
              private tipoUsuarioService: TipoUsuarioService,
              private estadosService: EstadosService,
              private cidadesService: CidadesService,
              private usuariosService: UsuarioService,
              private toasty: ToastyService,
              private errorHandle: ErrorHandlerService,
              private router: Router,
              private route: ActivatedRoute) { }


  ngOnInit() {
    this.consultarTipoUsuario();
    this.consultarEstados();
    this.consultarCidades();
    this.consultarUsuarios();
    this.consultarColaborador();

    var id = this.route.params.subscribe(params => {
      var id = params['id'];

      this.colaboradorService.consultarPorId(id) 
      .then(
        colaborador => this.colaborador = colaborador,
        response => {
          if (response.status == 404) {
            this.router.navigate(['Não Encontrado']);
          }
        })           
    });
  }

  get editando(){
    return Boolean (this.route.snapshot.params['id']);
  }

  consultarEstados(){
    this.estadosService.consultar()
    .then(estados => this.estados = estados.map(e => {
      return {label: e.estado, value: e.id  };
    }))
    .catch(erro => this.errorHandle.handle(erro));
  }

  consultarCidades(){
    this.cidadesService.consultar()
    .then(cidades => this.cidades = cidades.map(c => {
      return {label: c.cidade, value: c.id  };
    }))
    .catch(erro => this.errorHandle.handle(erro));
  }

  consultarTipoUsuario(){
    this.tipoUsuarioService.consultar()
    .then(tipos => this.tipos = tipos.map(t => {
      return {label: t.descricao, value: t.id  };
    }))
    .catch(erro => this.errorHandle.handle(erro));
  }

  consultarUsuarios(){
    this.usuariosService.consultar()
    .then(usuarios => this.usuarios = usuarios)
    .catch(erro => this.errorHandle.handle(erro))
    console.log(this.usuarios)
  }

  consultarColaborador(){
    this.colaboradorService.consultar()
    .then(colaboradores => this.colaboradores = colaboradores)
    .catch(erro => this.errorHandle.handle(erro))
    console.log(this.colaborador)
  }

  atualizarColaborador(frm: FormControl){
    this.colaboradorService.atualizar(this.colaborador)    
      frm.reset()
      this.toasty.success('Colaborador cadastrado com sucessso!')
      //this.route.navigate(['avaliacao-fisica']);
          
    }
  
}
