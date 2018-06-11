import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders, Component } from '@angular/core';

import { FormAcademiaComponent } from './academia/form-academia/form-academia.component';
import { AcademiaComponent } from './academia/academia.component';
import { CriarContaComponent } from './criar-conta/criar-conta.component';
import { TreinoComponent } from './treino/treino.component';
import { AvaliacaoFisicaComponent } from './avaliacao-fisica/avaliacao-fisica.component';
import { LoginFormComponent } from './seguranca/login-form/login-form.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AlunoComponent } from './aluno/aluno.component';
import { FormAlunoComponent } from './aluno/form-aluno/form-aluno.component';
import { FormAvaliacaoFisicaComponent } from './avaliacao-fisica/form-avaliacao-fisica/form-avaliacao-fisica.component';
import { RecuperarSenhaComponent } from './seguranca/recuperar-senha/recuperar-senha.component';
import { FormTreinoComponent } from './treino/form-treino/form-treino.component';


const APP_ROUTES: Routes = [
  
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: LoginFormComponent },
  { path: 'dashboard', component: DashboardComponent },
  
  { path: 'academias', component: AcademiaComponent},
  { path: 'academias/adicionar', component: FormAcademiaComponent},
  { path: 'academias/:id', component: FormAcademiaComponent},

  { path: 'alunos', component: AlunoComponent},
  { path: 'alunos/adicionar', component: FormAlunoComponent},
  { path: 'alunos/:id', component: FormAlunoComponent},

  { path: 'avaliacoes-fisicas', component: AvaliacaoFisicaComponent },
  { path: 'avaliacoes-fisicas/adicionar', component: FormAvaliacaoFisicaComponent},
  { path: 'avaliacoes-fisicas/:id', component: FormAvaliacaoFisicaComponent},

  { path: 'treinos', component: TreinoComponent},
  { path: 'treinos/:id', component: FormTreinoComponent },
  { path: 'treinos/adicionar', component: FormTreinoComponent },

  { path: 'exercicios', component: TreinoComponent},
  { path: 'exercicios/:id', component: FormTreinoComponent },
  { path: 'exercicios/adicionar', component: FormTreinoComponent },

  { path: 'recuperar-senha', component: RecuperarSenhaComponent},
  { path: 'criar-conta', component: CriarContaComponent },

];

export const routing: ModuleWithProviders = RouterModule.forRoot(APP_ROUTES);
