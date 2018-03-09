import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { nullSafeIsEquivalent } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor( private formBuilder: FormBuilder) { }

  ngOnInit() {

      // this.loginForm = new FormGroup({
      //   email: new FormControl(null),
      //   senha: new FormControl(null)
      // });

      this.loginForm = this.formBuilder.group({
        email: [null],
        senha: [null]
      });

  }

}
