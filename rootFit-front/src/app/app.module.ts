import { AuthService } from './seguranca/auth.service';
import { SharedModule } from './shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppBootstrapModule } from './app-bootstrap.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { JwtHelper } from 'angular2-jwt';

import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MenuComponent } from './menu/menu.component';
import { AlunoService } from './shared/services/aluno.service';
import { InstrutorService } from './shared/services/instrutor.service';
import { ColaboradorService } from './shared/services/colaborador.service';
import { ColaboradorComponent } from './colaborador/colaborador.component';
import { FormComponent } from './colaborador/form/form.component';
import { FormEnderecoComponent } from './shared/form-endereco/form-endereco.component';
import { CadastrarUsuarioComponent } from './cadastrar-usuario/cadastrar-usuario.component';
import { SegurancaComponent } from './seguranca/seguranca.component';
import { LoginFormComponent } from './seguranca/login-form/login-form.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    MenuComponent,
    ColaboradorComponent,
    FormComponent,
    FormEnderecoComponent,
    CadastrarUsuarioComponent,
    SegurancaComponent,
    LoginFormComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    HttpClientModule,
    AppBootstrapModule,
    FormsModule,
    SharedModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    routing

  ],
  providers: [
    AlunoService, 
    InstrutorService, 
    ColaboradorService, 
    AuthService,
    JwtHelper,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
