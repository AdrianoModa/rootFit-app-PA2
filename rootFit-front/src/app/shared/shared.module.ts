import { HttpClientModule } from '@angular/common/http';
import { ColaboradorService } from './services/colaborador.service';
import { InstrutorService } from './services/instrutor.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormDebugComponent } from './form-debug/form-debug.component';
import { FormsModule } from '@angular/forms';
import { AlunoService } from './services/aluno.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  declarations: [
    FormDebugComponent
  ],
  exports: [
    FormDebugComponent
  ],
  providers: [AlunoService, InstrutorService, ColaboradorService]
})
export class SharedModule { }
