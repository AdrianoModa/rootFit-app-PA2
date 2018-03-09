import { SharedModule } from './shared/shared.module';
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
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { AlunoService } from './shared/services/aluno.service';
import { InstrutorService } from './shared/services/instrutor.service';

@NgModule({
  declarations: [
    AppComponent,
    ListarClientesComponent,
    DashboardComponent,
    MenuComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    HttpClientModule,
    AppBootstrapModule,
    FormsModule,
    SharedModule,
    ReactiveFormsModule,
    routing

  ],
  providers: [AlunoService, InstrutorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
