import { AuthService } from './seguranca/auth.service';
import { SharedModule } from './shared/shared.module';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

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
import { SegurancaModule } from './seguranca/seguranca.module';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    MenuComponent,
    ColaboradorComponent,
    FormComponent,
    FormEnderecoComponent,
    CadastrarUsuarioComponent,
    SidebarComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    SharedModule,
    SegurancaModule,
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
