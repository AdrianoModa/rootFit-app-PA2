import { CidadesService } from './shared/services/cidades.service';
import { EstadosService } from './shared/services/estados.service';
import { ExercicioService } from './shared/services/exercicio.service';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { JwtHelper } from 'angular2-jwt';
import { ToastyModule } from 'ng2-toasty';

import { ErrorHandlerService } from './shared/services/error-handler.service';
import { AuthService } from './seguranca/auth.service';
import { SharedModule } from './shared/shared.module';
import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AlunoService } from './shared/services/aluno.service';
import { InstrutorService } from './shared/services/instrutor.service';
import { ColaboradorService } from './shared/services/colaborador.service';
import { AlunoComponent } from './aluno/aluno.component';
import { FormAlunoComponent } from './aluno/form-aluno/form-aluno.component';
import { FormEnderecoComponent } from './shared/form-endereco/form-endereco.component';
import { SegurancaModule } from './seguranca/seguranca.module';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AvaliacaoFisicaComponent } from './avaliacao-fisica/avaliacao-fisica.component';
import { FormAvaliacaoFisicaComponent } from './avaliacao-fisica/form-avaliacao-fisica/form-avaliacao-fisica.component';
import { AvaliacaoFisicaService } from './shared/services/avaliacao-fisica.service';
import { TreinoComponent } from './treino/treino.component';
import { FormTreinoComponent } from './treino/form-treino/form-treino.component';
import { TreinoService } from './shared/services/treino.service';
import { TipoUsuarioService } from './shared/services/tipo-usuario.service';
import { UsuarioService } from './shared/services/usuario.service';
import { CriarContaComponent } from './criar-conta/criar-conta.component';
import { ExerciciosComponent } from './exercicios/exercicios.component';
import { FormExerciciosComponent } from './exercicios/form-exercicios/form-exercicios.component';
import { AcademiaComponent } from './academia/academia.component';
import { FormAcademiaComponent } from './academia/form-academia/form-academia.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    AlunoComponent,
    FormAlunoComponent,
    FormEnderecoComponent,
    SidebarComponent,
    NavbarComponent,
    AvaliacaoFisicaComponent,
    FormAvaliacaoFisicaComponent,
    TreinoComponent,
    FormTreinoComponent,
    CriarContaComponent,
    ExerciciosComponent,
    FormExerciciosComponent,
    AcademiaComponent,
    FormAcademiaComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    SharedModule,
    SegurancaModule,
    ReactiveFormsModule,
    ToastyModule.forRoot(),
    routing
  ],
  providers: [
    AlunoService, 
    InstrutorService, 
    ColaboradorService, 
    AvaliacaoFisicaService,
    TreinoService,
    ExercicioService,
    AuthService,
    JwtHelper,
    ErrorHandlerService,
    TipoUsuarioService,
    EstadosService,
    CidadesService,
    UsuarioService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
