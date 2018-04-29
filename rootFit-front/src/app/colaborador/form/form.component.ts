import { Component, OnInit } from '@angular/core';
import { Colaborador } from '../../shared/entities/colaborador';
import { ColaboradorService } from '../../shared/services/colaborador.service';
import { FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  colaboradores: Colaborador[] = [];


  constructor(private colaboradorService: ColaboradorService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {

    /*this.listar();

    const codigoColaborador = this.route.snapshot.params['id'];
    if (codigoColaborador) {
      this.buscarPorId(codigoColaborador);
    }

  }

  get editando() {
    return Boolean (this.route.snapshot.params['id']);
  }

  listar() {
    this.colaboradorService.listar()
    .subscribe(data => this.colaboradores = data);
  }

  buscarPorId(id: number) {
    this.colaboradorService.bucarPorId(id)
    .subscribe(data => this.colaboradores = data);
  }

  salvar(frm: FormControl) {
    if (this.editando) {
      this.atualizar(frm);
    } else {
      this.adicionar(frm);
    }
  }

  atualizar(frm: FormControl) {
    this.colaboradorService.atualizar(this.colaboradores)
    .subscribe(() => {

    });
  }


  adicionar(frm: FormControl) {
    this.colaboradorService.adicionar(frm.value)
    .subscribe(() => {
    });
  }

  remover(colaboradores) {
    if (confirm('Deseja remover o colaborador:  ' + colaboradores.nome + '?')) {
      const index = this.colaboradores.indexOf(colaboradores);
      this.colaboradores.splice(index, 1);

      this.colaboradorService.remover(colaboradores.id)
        .subscribe(null,
          err => {
            alert('Colaborador não removido.');
            // Revert the view back to its original state
            this.colaboradores.splice(index, 0, colaboradores);
          });

    }*/
  }
}
