import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { ToastyConfig } from 'ng2-toasty';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private router: Router, private toastyConfig: ToastyConfig ){
    this.toastyConfig.theme = 'bootstrap';
  }

  exibindoMenu(){
    return this.router.url !== '/login';
  }

  exibindoMenuCriarConta(){
    return this.router.url !== '/criar-conta';
  }
}
