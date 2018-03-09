import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders, Component } from '@angular/core';

import { AppComponent } from './app.component';
import { ListarClientesComponent } from './listar-clientes/listar-clientes.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';


const APP_ROUTES: Routes = [

  {path: '', component: DashboardComponent},
  {path: 'clientes', component: ListarClientesComponent},
  {path: 'login', component: LoginComponent}

];

export const routing: ModuleWithProviders = RouterModule.forRoot(APP_ROUTES);
