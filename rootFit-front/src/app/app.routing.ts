import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders, Component } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { ColaboradorComponent } from './colaborador/colaborador.component';
import { FormComponent } from './colaborador/form/form.component';


const APP_ROUTES: Routes = [

  { path: '', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'colaborador', component: ColaboradorComponent},
  { path: 'colaborador/adicionar', component: FormComponent},
  { path: 'colaborador/:id', component: FormComponent}

];

export const routing: ModuleWithProviders = RouterModule.forRoot(APP_ROUTES);
