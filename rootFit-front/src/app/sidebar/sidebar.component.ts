import { Component, OnInit } from '@angular/core';
import { AuthService } from '../seguranca/auth.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {

  constructor(private auth: AuthService) { }

  ngOnInit() {
   
  }
}

