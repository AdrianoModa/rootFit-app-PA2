import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-seguranca',
  templateUrl: './seguranca.component.html',
  styleUrls: ['./seguranca.component.css']
})
export class SegurancaComponent implements OnInit {

  loginImage:string = "./../assets/img/capagym.jpg" 
  logoImage:string = "./../assets/logo.jpg"

  constructor() { }

  ngOnInit() {
      
  }

  getUrl() {
  return "url('./../assets/img/capagym.jpg')";
  }
}
