import { SegurancaComponent } from './seguranca/seguranca.component';
import { CadastrarUsuarioComponent } from './cadastrar-usuario/cadastrar-usuario.component';
import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders, Component } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ColaboradorComponent } from './colaborador/colaborador.component';
import { FormComponent } from './colaborador/form/form.component';


const APP_ROUTES: Routes = [

  
 
  { path: 'login', component: SegurancaComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'dashboard', component: DashboardComponent },
  { path: 'colaborador', component: ColaboradorComponent},
  { path: 'colaborador/adicionar', component: FormComponent},
  { path: 'colaborador/:id', component: FormComponent},
  { path: 'cadastrar-usuario', component: CadastrarUsuarioComponent}
  

];

export const routing: ModuleWithProviders = RouterModule.forRoot(APP_ROUTES);
