import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ListarClientesComponent } from './listar-clientes/listar-clientes.component';


@NgModule({
  declarations: [
    AppComponent,
    ListarClientesComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
