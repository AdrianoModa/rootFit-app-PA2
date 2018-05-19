import { PerfilComponent } from './colaborador/perfil/perfil.component';
import { CadastrarAvaliacaoFisicaComponent } from './cadastrar-avaliacao-fisica/cadastrar-avaliacao-fisica.component';
import { LoginFormComponent } from './seguranca/login-form/login-form.component';
import { CadastrarUsuarioComponent } from './cadastrar-usuario/cadastrar-usuario.component';
import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders, Component } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ColaboradorComponent } from './colaborador/colaborador.component';
import { FormComponent } from './colaborador/form/form.component';
import { FormAvaliacaoFisicaComponent } from './cadastrar-avaliacao-fisica/form-avaliacao-fisica/form-avaliacao-fisica.component';


const APP_ROUTES: Routes = [

  
 
  { path: 'login', component: LoginFormComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'dashboard', component: DashboardComponent },
  { path: 'listar-usuarios', component: ColaboradorComponent},
  { path: 'listar-usuarios/adicionar', component: FormComponent},
  { path: 'listar-usuarios/:id', component: FormComponent},
  { path: 'cadastrar-usuarios', component: CadastrarUsuarioComponent},
  { path: 'cadastrar-avaliacao-fisica', component: FormAvaliacaoFisicaComponent},
  { path: 'perfil', component: PerfilComponent},
  { path: 'avaliacao-fisica', component: CadastrarAvaliacaoFisicaComponent }
  

];

export const routing: ModuleWithProviders = RouterModule.forRoot(APP_ROUTES);
