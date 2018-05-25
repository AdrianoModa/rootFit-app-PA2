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
import { MenuComponent } from './menu/menu.component';
import { AlunoService } from './shared/services/aluno.service';
import { InstrutorService } from './shared/services/instrutor.service';
import { ColaboradorService } from './shared/services/colaborador.service';
import { ListarUsuariosComponent } from './listar-usuarios/listar-usuarios.component';
import { FormComponent } from './listar-usuarios/form/form.component';
import { FormEnderecoComponent } from './shared/form-endereco/form-endereco.component';
import { CadastrarUsuarioComponent } from './cadastrar-usuario/cadastrar-usuario.component';
import { SegurancaModule } from './seguranca/seguranca.module';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CadastrarAvaliacaoFisicaComponent } from './cadastrar-avaliacao-fisica/cadastrar-avaliacao-fisica.component';
import { FormAvaliacaoFisicaComponent } from './cadastrar-avaliacao-fisica/form-avaliacao-fisica/form-avaliacao-fisica.component';
import { AvaliacaoFisicaService } from './shared/services/avaliacao-fisica.service';
import { PerfilComponent } from './listar-usuarios/perfil/perfil.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    MenuComponent,
    ListarUsuariosComponent,
    FormComponent,
    FormEnderecoComponent,
    CadastrarUsuarioComponent,
    SidebarComponent,
    NavbarComponent,
    CadastrarAvaliacaoFisicaComponent,
    FormAvaliacaoFisicaComponent,
    PerfilComponent
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
    AuthService,
    JwtHelper,
    ErrorHandlerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
