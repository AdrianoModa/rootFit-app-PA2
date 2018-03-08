import { ListarClientesComponent } from './../listar-clientes/listar-clientes.component';
import { HttpClientModule } from '@angular/common/http';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginComponent } from './login.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SharedModule } from './../shared/shared.module';
import { LoginService } from './login.service';
@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule
  ],
  declarations: [
   LoginComponent,
  ],
  providers: [LoginService],
})
export class LoginModule { }
