import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-academia',
  templateUrl: './form-academia.component.html',
  styleUrls: ['./form-academia.component.css']
})
export class FormAcademiaComponent implements OnInit {

  status = [
    {id: 0, descricao: "Ativo"},
    {id: 1, descricao: "Inativo"}
  ]

  constructor() { }

  ngOnInit() {
  }

}
