import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppBootstrapModule } from './app-bootstrap.module';

import { AppComponent } from './app.component';
import { ListarClientesComponent } from './listar-clientes/listar-clientes.component';
import { routing } from './app.routing';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ListarClientesService } from './listar-clientes/listar-clientes.service';
import { MenuComponent } from './menu/menu.component';
import { LoginModule } from './login/login.module';


@NgModule({
  declarations: [
    AppComponent,
    ListarClientesComponent,
    DashboardComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    HttpClientModule,
    AppBootstrapModule,
    FormsModule,
    ReactiveFormsModule,
    LoginModule,
    routing

  ],
  providers: [ListarClientesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
