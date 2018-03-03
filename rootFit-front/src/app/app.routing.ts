import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

import { AppComponent } from './app.component';
import { ListarClientesComponent } from './listar-clientes/listar-clientes.component';
import { DashboardComponent } from './dashboard/dashboard.component';


const APP_ROUTES: Routes = [

  {path: '', component: DashboardComponent},
  {path: 'clientes', component: ListarClientesComponent}

];

export const routing: ModuleWithProviders = RouterModule.forRoot(APP_ROUTES);
